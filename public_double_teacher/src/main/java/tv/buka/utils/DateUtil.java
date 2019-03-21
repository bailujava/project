package tv.buka.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * 日期操作辅助类
 */
public final class DateUtil {
    private DateUtil() {}

    /**
     * 日期格式
     **/
    public interface DATE_PATTERN {
        String HHMMSS = "HHmmss";
        String HH_MM_SS = "HH:mm:ss";
        String YYYYMMDD = "yyyyMMdd";
        String YYYY_MM_DD = "yyyy-MM-dd";
        String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
        String MMDDHHMM = "MMddHHmm";
        String YYYY_MM_DD_HH_MM = "YYYY-MM-DD HH:mm";
        String YYYYMMDDHHMMSSSSS = "yyyyMMddHHmmssSSS";
        String UTC_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'";
        String UTC_YYYY_MM_DDTHH_MM = "yyyy-MM-dd'T'HH:mm";
        String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    }

    /**
     * 格式化日期
     */
    public static final String format(Object date) {
        return format(date, DATE_PATTERN.YYYY_MM_DD);
    }

    public static final String format(Object date, String pattern) {
        if (date == null) {
            return null;
        }
        if (pattern == null) {
            return format(date);
        }
        return new SimpleDateFormat(pattern).format(date);
    }

    /**
     * 获取日期
     */
    public static final String getDate() {
        return format(new Date());
    }

    public static final String getDateTime() {
        return format(new Date(), DATE_PATTERN.YYYY_MM_DD_HH_MM_SS);
    }

    public static final String getDateTime(String pattern) {
        return format(new Date(), pattern);
    }

    /**
     * 日期计算
     */
    public static final Date addDate(Date date, int field, int amount) {
        if (date == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(field, amount);
        return calendar.getTime();
    }

    /**
     * 字符串转换为日期:不支持yyM[M]d[d]格式
     */
    public static final Date stringToDate(String date) {
        if (date == null) {
            return null;
        }
        String separator = String.valueOf(date.charAt(4));
        String pattern = "yyyyMMdd";
        if (!separator.matches("\\d*")) {
            pattern = "yyyy" + separator + "MM" + separator + "dd";
            if (date.length() < 10) {
                pattern = "yyyy" + separator + "M" + separator + "d";
            }
        } else if (date.length() < 8) {
            pattern = "yyyyMd";
        }
        pattern += " HH:mm:ss.SSS";
        pattern = pattern.substring(0, Math.min(pattern.length(), date.length()));
        try {
            return new SimpleDateFormat(pattern).parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 间隔天数
     */
    public static final Integer getDayBetween(Date startDate, Date endDate) {
        Calendar start = Calendar.getInstance();
        start.setTime(startDate);
        start.set(Calendar.HOUR_OF_DAY, 0);
        start.set(Calendar.MINUTE, 0);
        start.set(Calendar.SECOND, 0);
        start.set(Calendar.MILLISECOND, 0);
        Calendar end = Calendar.getInstance();
        end.setTime(endDate);
        end.set(Calendar.HOUR_OF_DAY, 0);
        end.set(Calendar.MINUTE, 0);
        end.set(Calendar.SECOND, 0);
        end.set(Calendar.MILLISECOND, 0);

        long n = end.getTimeInMillis() - start.getTimeInMillis();
        return (int) (n / (60 * 60 * 24 * 1000l));
    }

    /**
     * 间隔月
     */
    public static final Integer getMonthBetween(Date startDate, Date endDate) {
        if (startDate == null || endDate == null || !startDate.before(endDate)) {
            return null;
        }
        Calendar start = Calendar.getInstance();
        start.setTime(startDate);
        Calendar end = Calendar.getInstance();
        end.setTime(endDate);
        int year1 = start.get(Calendar.YEAR);
        int year2 = end.get(Calendar.YEAR);
        int month1 = start.get(Calendar.MONTH);
        int month2 = end.get(Calendar.MONTH);
        int n = (year2 - year1) * 12;
        n = n + month2 - month1;
        return n;
    }

    /**
     * 间隔月，多一天就多算一个月
     */
    public static final Integer getMonthBetweenWithDay(Date startDate, Date endDate) {
        if (startDate == null || endDate == null || !startDate.before(endDate)) {
            return null;
        }
        Calendar start = Calendar.getInstance();
        start.setTime(startDate);
        Calendar end = Calendar.getInstance();
        end.setTime(endDate);
        int year1 = start.get(Calendar.YEAR);
        int year2 = end.get(Calendar.YEAR);
        int month1 = start.get(Calendar.MONTH);
        int month2 = end.get(Calendar.MONTH);
        int n = (year2 - year1) * 12;
        n = n + month2 - month1;
        int day1 = start.get(Calendar.DAY_OF_MONTH);
        int day2 = end.get(Calendar.DAY_OF_MONTH);
        if (day1 <= day2) {
            n++;
        }
        return n;
    }

    /**
     * 传入Date,获取指定分钟后的Date
     */
    public static Date addMinute(Date date, int minute) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MINUTE, minute);
        return new Date(cal.getTime().getTime());
    }

    /**
     * <pre>时间加减运算、传入小时数</pre>
     */
    public static Date calc(Date dateTime, int hours) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(dateTime);
        cal.add(Calendar.HOUR_OF_DAY, hours);
        return cal.getTime();
    }

    //判断是否当前时间(精确到分钟)
    public static boolean checkDateTimeIsNow(Date date) {
        String format = format(date, DATE_PATTERN.YYYY_MM_DD_HH_MM);
        String format1 = format(new Date(), DATE_PATTERN.YYYY_MM_DD_HH_MM);
        if (format.equals(format1)) {
            return true;
        }
        return false;
    }

    //指定格式字符串时间转为Date类型
    public static Date getDate(String dateText, String pattern) {
        DateFormat dateFormat = createDateFormat(pattern);
        try {
            return dateFormat.parse(dateText);
        } catch (ParseException e) {
            throw new IllegalStateException("Parse date from [" + dateText + "," + pattern + "] failed", e);
        }
    }

    //DateFormat
    private static DateFormat createDateFormat(String pattern) {
        return new SimpleDateFormat(pattern, Locale.SIMPLIFIED_CHINESE);
    }

    //获取今日MMddhhmm
    public static String toDayTime() {
        return format(new Date(), DATE_PATTERN.MMDDHHMM);
    }

    //获取今日yyyy-MM-dd
    public static String toDay() {
        return format(new Date(), DATE_PATTERN.YYYY_MM_DD);
    }

    //获取今日起始时间13位时间戳
    public static Long toDayTimeStamp() {
        return stringToDate(format(new Date(), DATE_PATTERN.YYYY_MM_DD)).getTime();
    }

    //n天之前的日期
    public static String getBeforeDaysTime(int num) {
        Calendar calendar1 = Calendar.getInstance();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        calendar1.add(Calendar.DATE, num);
        String num_days_ago = sdf1.format(calendar1.getTime());
        return num_days_ago;
    }

    //n小时之前的日期
    public static String getBeforeHourTime(int ihour) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) - ihour);
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        String num_hour_ago = df.format(calendar.getTime());
        return num_hour_ago;
    }

    //n小时之前的时间戳
    public static Long BeforeHourTime(int ihour) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) - ihour);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String num_hour_ago = df.format(calendar.getTime());
        Long aLong = stringTolong(num_hour_ago);
        return aLong;
    }

    /*
    * 时间格式转时间戳
    * */
    public static Long stringTolong(String timestr) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Long ltime = null;
        try {
            if(timestr.length()==10){
                timestr+=" 00:00:00";
            }
            Date dtime = sdf.parse(timestr);
            ltime = dtime.getTime();
        } catch (ParseException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
        return ltime;
    }

    public static Long sgetnextlong(String timestr) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Long ltime = null;
        try {
            if(timestr.length()==10){
                timestr+=" 23:59:59";
            }
            Date dtime = sdf.parse(timestr);
            ltime = dtime.getTime();
        } catch (ParseException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
        return ltime;
    }

    /*
    * 时间戳转时间格式
    * */
    public static String longTostring(Long timeStamp){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//这个是你要转成后的时间的格式
        String sd = sdf.format(new Date(Long.parseLong(String.valueOf(timeStamp))));
        return sd;
    }

    /*
     * 将时间戳转换为时间
     */
    public static String stampToDate(String time){
        String datetime;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long ltime = new Long(time);
        Date date = new Date(ltime);
        datetime = simpleDateFormat.format(date);
        return datetime;
    }

    /*
    * 时间戳前后几分钟
    * */
    public static long getTimeByMinute(long time,int minute) {
        Date date = new Date(time);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, minute);
        return calendar.getTime().getTime();
    }

    public static long Sametimeformat(String time) throws ParseException {
        time=time.trim();
        long record=0;
        if(time.contains("-") && time.contains("M")){
            if(time.contains("AM")){
                time=time.substring(0,19);
            }else if(time.contains("PM")){
                String before=time.substring(11,14);
                String after=(Integer.valueOf(before.substring(0,2))+12)+":";
                time.replace(before,after);
            }
            record = stringTolong(time)/1000;
        }else if(time.contains("-") && !time.contains("M")){
            record = stringTolong(time)/1000;
        }else if(time.length()==19 && !time.contains("-")){
            Long date=Long.valueOf(time);
            record =date/1000000000;
        }else if(time.length()==13 && !time.contains("-")){
            record =Long.valueOf(time)/1000;
        }else if(time.length()==14){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            Date dateString = sdf.parse(time);
            record=dateString.getTime()/1000;
        }else{
            record=Long.valueOf(time);
        }
        return record;
    }

    public static void main(String[] args){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        Date dateString = null;
        try {
            dateString = sdf.parse("20180626152152");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(dateString.getTime());
    }
}
