package com.sevent.shihuilaw.security.service;

import com.octo.captcha.engine.CaptchaEngine;
import com.octo.captcha.engine.image.ListImageCaptchaEngine;
import com.octo.captcha.service.captchastore.CaptchaStore;
import com.octo.captcha.service.captchastore.FastHashMapCaptchaStore;
import com.octo.captcha.service.image.AbstractManageableImageCaptchaService;
import com.octo.captcha.service.image.DefaultManageableImageCaptchaService;
import com.octo.captcha.service.image.ImageCaptchaService;
import com.sevent.shihuilaw.security.SampleListImageCaptchaEngine;

/**
 * Created by liupengfei on 2017/3/20.
 */
public class SampleImageCaptcha extends
        AbstractManageableImageCaptchaService implements ImageCaptchaService{

    private static ImageCaptchaService instance;

    protected SampleImageCaptcha(CaptchaStore captchaStore, CaptchaEngine captchaEngine,
                                 int minGuarantedStorageDelayInSeconds, int maxCaptchaStoreSize,
                                 int captchaStoreLoadBeforeGarbageCollection) {
        super(captchaStore, captchaEngine, minGuarantedStorageDelayInSeconds,
                maxCaptchaStoreSize, captchaStoreLoadBeforeGarbageCollection);
    }

    /**
     * Get default manageable image captcha service
     * @return ImageCaptchaService
     */
    public static ImageCaptchaService getInstance() {
        if (instance == null) {
            ListImageCaptchaEngine engine = new SampleListImageCaptchaEngine();

            instance = new DefaultManageableImageCaptchaService(new FastHashMapCaptchaStore(),
                    engine, 120, 100000, 70000);
        }
        return instance;
    }
}
