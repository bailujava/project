package org.ibase4j.core;


import com.sun.istack.internal.logging.Logger;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.stereotype.Component;

import com.weibo.api.motan.common.MotanConstants;
import com.weibo.api.motan.util.MotanSwitcherUtil;

import top.ibase4j.core.listener.ApplicationReadyListener;



@Component
public class BizServerListener extends ApplicationReadyListener {
    protected final Logger logger = Logger.getLogger(BizServerListener .class);

    public void onApplicationEvent(ApplicationReadyEvent event) {
        MotanSwitcherUtil.setSwitcherValue(MotanConstants.REGISTRY_HEARTBEAT_SWITCHER, true);
        super.onApplicationEvent(event);
    }
}
