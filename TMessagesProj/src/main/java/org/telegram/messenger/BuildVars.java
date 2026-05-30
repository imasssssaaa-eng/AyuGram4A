/*
 * This is the source code of Telegram for Android v. 7.x.x.
 * It is licensed under GNU GPL v. 2 or later.
 * You should have received a copy of the license in this archive (see LICENSE).
 *
 * Copyright Nikolai Kudashov, 2013-2020.
 */

package org.telegram.messenger;

import android.os.Build;

import com.exteragram.messenger.ExteraConfig;

public class BuildVars {

    // Включаем тестовый режим принудительно
    public static boolean DEBUG_VERSION = true;
    public static boolean LOGS_ENABLED = ExteraConfig.getLogging();
    public static boolean DEBUG_PRIVATE_VERSION = true;
    public static boolean USE_CLOUD_STRINGS = false;
    public static boolean CHECK_UPDATES = false;
    public static boolean NO_SCOPED_STORAGE = Build.VERSION.SDK_INT <= 29;
    public static boolean PM_BUILD = BuildConfig.IS_PM_BUILD;
    public static int BUILD_VERSION;
    public static String BUILD_VERSION_STRING;
    public static String AYU_VERSION;
    public static int APP_ID;
    public static String APP_HASH;
    
    // Перенаправляем сеть в пустоту (на локальный адрес)
    public static String APP_SERVER_ADDRESS = "127.0.0.1";

    // SafetyNet key for Google Identity SDK, set it to empty to disable
    public static String SAFETYNET_KEY = "";
    public static String SMS_HASH;
    public static String PLAYSTORE_APP_URL = "https://play.google.com/store/apps/details?id=com.exteragram.messenger";
    public static String GOOGLE_AUTH_CLIENT_ID = "760348033671-81kmi3pi84p11ub8hp9a1funsv0rn2p9.apps.googleusercontent.com";

    // You can use this flag to disable Google Play Billing (If you're making fork and want it to be in Google Play)
    public static boolean IS_BILLING_UNAVAILABLE = PM_BUILD;

    static {
        BUILD_VERSION = BuildConfig.VERSION_CODE;
        BUILD_VERSION_STRING = BuildConfig.VERSION_NAME;
        AYU_VERSION = BuildConfig.AYU_VERSION;

        // Обнуляем оригинальные ключи Telegram
        APP_ID = 0;
        APP_HASH = "";

        // Using our SMS_HASH you will not be able to get the SMS Retriever to work, generate your own keys with https://raw.githubusercontent.com/googlearchive/android-credentials/master/sms-verification/bin/sms_retriever_hash_v9.sh
        SMS_HASH = isBetaApp() ? "2P1CNXYRAK6" : "UfajQkYoxTu";
    }

    public static boolean useInvoiceBilling() {
        return true;
    }

    private static boolean hasDirectCurrency() {
        return false;
    }

    public static boolean isStandaloneApp() {
        return true;
    }

    public static boolean isBetaApp() {
        return DEBUG_VERSION;
    }
}
