package tv.buka.common;

import org.apache.commons.lang3.StringUtils;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class AccessToken {
	private long beginTime = System.currentTimeMillis() / 1000;

	private static class LazyHolder {
		private static final AccessToken INSTANCE = new AccessToken();
	}

	public static final AccessToken getInstance() {
		return LazyHolder.INSTANCE;
	}

	private Set<String> userSet = new HashSet<String>();

	public void addUserToken(String accessToken) {
		userSet.add(accessToken);
	}

	public void containsUserToken(String accessToken) {
		userSet.contains(accessToken);
	}

	public void removeUserToken(String accessToken) {
		userSet.remove(accessToken);
	}

	private Set<String> organizationSet = new HashSet<String>();

	public void addOrganizationToken(String accessToken) {
		organizationSet.add(accessToken);
	}

	public void containsOrganizationToken(String accessToken) {
		organizationSet.contains(accessToken);
	}

	public void removeOrganizationToken(String accessToken) {
		organizationSet.remove(accessToken);
	}

	private final String TAG_SPLIT = "@";
	private final String TAG_START = "*";
	private final String TAG_END = "+";
	private final String FLAG_FALSE = "#";

	public Integer getIdByToken(String token) {
		String info = SecurityUtils.AESDecrypt(token);
		if (StringUtils.isNotBlank(info) && info.startsWith(TAG_START)
				&& info.endsWith(TAG_END)) {
			info = info.substring(TAG_START.length());
			info = info.substring(0, info.length() - TAG_END.length());
			String[] strs = info.split(TAG_SPLIT);
			if (strs.length == 4 && StringUtils.isNumeric(strs[1])) {
				return Integer.valueOf(strs[1]);
			}
		}
		return null;
	}

	public boolean check(String accessToken, String device) {
		if (StringUtils.isBlank(accessToken)
				|| StringUtils.isBlank(SecurityUtils.AESDecrypt(accessToken))) {
			return false;
		}
		String info = SecurityUtils.AESDecrypt(accessToken);
		if (!info.startsWith(TAG_START) || !info.endsWith(TAG_END)) {
			return false;
		}
		info = info.substring(TAG_START.length());
		info = info.substring(0, info.length() - TAG_END.length());
		String[] infos = info.split(TAG_SPLIT);
		if (infos.length != 4 ||  !StringUtils.isNumeric(infos[1])) {
			return false;
		}
		String checkDevice = infos[3];
		if (!checkDevice(checkDevice, device)) {
			return false;
		}
		return true;
	}


	public String createAccessToken(int id, long time,
			String device) {
		return SecurityUtils.AESEncrypt(TAG_START + FLAG_FALSE
				+ TAG_SPLIT + id + TAG_SPLIT + (time / 1000 - beginTime)
				+ TAG_SPLIT + getDevice(device) + TAG_END);
	}

	public static void main(String[] args) {
		String accessToken = getInstance().createAccessToken(55354, System.currentTimeMillis(), "123456");
		System.out.println(accessToken);
	}

	private boolean checkDevice(String device, String checkDevice) {
		if (device == null || device.length() == 0)
			return false;
		if (checkDevice == null || checkDevice.length() == 0) {
			if (device.equals("000"))
				return true;
			return false;
		}
		checkDevice = getShortDevice(checkDevice);
		if (!device.startsWith(checkDevice.length() + ""))
			return false;
		device = device.substring(1);
		String[] c = new String[checkDevice.length()];
		for (int i = 0; i < c.length; i++) {
			c[i] = checkDevice.substring(i, i + 1);
		}
		for (int i = 0; i < 2; i++) {
			int ri = Integer.valueOf(device.substring(i * 2, i * 2 + 1));
			String s = c[ri];
			c = nc(c, ri);
			String currentStr = device.substring(i * 2 + 1, i * 2 + 2);
			if (!s.equals(currentStr)) {
				return false;
			}
		}
		return true;
	}

	private static String getShortDevice(String device) {
		while (device.length() > 9) {
			String tmp = "";
			for (int i = 0; i < device.length(); i++) {
				if (i % 2 == 0) {
					tmp += device.substring(i, i + 1);
				}
				if (tmp.length() == 9) {
					tmp += device.substring(i);
					break;
				}
			}
			device = tmp;
		}
		if (device.length() == 1) {
			device += device;
		}
		return device;
	}

	private String getDevice(String device) {
		if (device == null || device.length() == 0) {
			return "000";
		}
		//大于10位缩小
		device = getShortDevice(device);
		//转换成数组
		String[] c = new String[device.length()];
		for (int i = 0; i < c.length; i++) {
			c[i] = device.substring(i, i + 1);
		}
		int length = c.length;
		String rs = length + "";
		for (int i = 0; i < 2; i++) {
			Random r = new Random();
			int ri = r.nextInt(length);
			String s = c[ri];
			c = nc(c, ri);
			rs += ri;
			rs += s;
			length = c.length;
		}
		return rs;
	}

	private String[] nc(String[] c, int j) {
		String[] nc = new String[c.length - 1];
		int z = 0;
		for (int i = 0; i < c.length; i++) {
			if (i != j) {
				nc[z] = c[i];
				z++;
			}
		}
		return nc;
	}



}
