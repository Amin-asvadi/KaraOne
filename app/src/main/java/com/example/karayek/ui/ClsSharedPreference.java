package com.example.karayek.ui;


import android.content.Context;
import android.content.SharedPreferences;

public class ClsSharedPreference {
    SharedPreferences.Editor editor;
    SharedPreferences.Editor editorsetting;


    private static final String TEL = "tel";
    private static final String PHONE = "phone";
    public static final String API_TOKEN = "api_token";
    public static final String UUID = "uuid";
    private static final String TELL = "tell";
    private static final String Address = "address";
    private static final String EMAIL = "email";
    public static final String KEY_TOKEN = "token";
    public static final String KEY_USERLNAME = "userlname";
    public static final String KEY_USERFNAME = "userfname";
    public static final String KEY_PHONE = "userphone";
    private static final String IS_LOGIN = "IsLoggedIn";
    private static final String CODE_PHONE = "code_phone";
    private static final String PREFNAMELGIN = "userlog";
    private static final String PRESETTING = "setting";
    public static final String IS_ACTIVE = "is_active";
    private static final String Reload_page = "reload_page";
    private static final String KEY_ADDRESS = "address";
    private static final String KEY_EMAIL = "ic_nav_pm";
    private static final String Limited_device = "limited_device";
    private static final String Reagent_text = "reagent_text";
    private static final String KEY_TELEPHONE = "telephone";
    private static final String KEY_TELEGRAM = "telegram";
    private static final String KEY_TELEGRAMCANAL = "telegramcanal";
    private static final String KEY_INSTAGRAM = "instegram";
    private static final String KEY_TWITTER = "twitter";
    private static final String KEY_FACEBOOK = "facebook";
    private static final String KEY_ABOUT_US = "about_us";
    private static final String MESSAGE_COUNT = "message_count";
    private static final String VERSION_APP = "version_app";
    private static final String KEY_CODE_REAGENTS = "code_reagents";
    private static final String LINK_VOICE_COMMENT = "link_voice";
    public static final String NEW_RELEASE = "new_release";
    private static final String KEY_PATHFILE = "profile_img";
    private static final String BUY = "buy";
    public static final String BUY_TRAIN = "buy_train";
    private static final String KEY_WALLET = "wallet";
    private static final String KEY_WALLETMIN = "walletChargeMinimum";
    private static final String FAV_TRAIN = "fav_train";
    private static final String FAV_COURSE = "fav_course";
    private static final String FAV_SHOPPRODUCT = "fav_shop_product";
    private static final String FAV_BLOG = "fav_blog";
    private static final String FAV_FILE = "fav_file";
    public static final String LINK_FILE = "link_file";
    public static final String LINK_NAME = "link_name";
    private static final String REPEAT_OFF = "repeat_off";
    private static final String REPEAT_All = "repeat_all";
    private static final String REPEAT_ONE = "repeat_one";
    private static final String ITEM_MY_QUESTION_REFRESH = "data_my_question_refresh";
    private static final String ITEM_MY_DISCUSS = "data_my_discuss";
    private static final String ITEM_ALL_DISCUSS = "data_all_discuss";
    public static final String like_dislike_all = "like_dislike_all";
    public static final String like_dislike_second = "like_dislike_second";
    public static final String like_dislike_third = "like_dislike_third";
    public static final String like_dislike_my = "like_dislike_my";
    public static final String like_dislike_search = "like_dislike_search";
    private static final String FRG_MYDISCUSS = "frg_mydiscuss";
    private static final String FRG_AllDISCUSS = "frg_alldiscuss";
    private static final String ID_FREE_COURSE = "uuid_course";
    public static final String ID_CLASS_CURRENT = "id_class_current";
    private static final String KEY_PHOTOPROFILE = "photo_profile";
    private static final String LIST_QUESTION = "list_question";
    private static final String LIST_MYQUESTION = "list_myquestion";
    private static final String VIDEO_FILE = "videofile";
    private static final String VOICE_FILE = "voicefile";
    private static final String PDF_FILE = "pdffile";
    private static final String DOWNLOAD_LINK = "download_link";
    private static final String KEY_TIMER_CODE = "timer_code";
    private static final String FRG_COMMENT = "comment";
    private static final String FRG_TRAINING = "training";
    private static final String FRG_COMPLETE = "complete";
    private static final String FRG_ALL_TYPE = "alltype";
    private static final String FONT_SIZE = "font_size";
    private static final String BUY_FILE = "buy_file";
    private static final String LIST_COMMENT = "list_comment";
    private static final String Fav_File_Offline = "fav_file_offline";
    private static final String User_Favorite_Train = "user_favorite_train";
    private static final String User_Favorite_Course = "user_favorite_course";
    private static final String User_Favorite_File = "user_favorite_file";
    private static final String ID_PROVINCE = "id_province";
    private static final String ID_CITY = "id_city";
    private static final String GENDER = "gender";
    private static final String NAME_CITY = "name_city";
    private static final String STORY = "story";
    private static final String POINT = "point";
    private static final String COUNT_PACKET = "count_packet";
    private static final String ITEM_CHANGE_All = "change_all";
    private static final String HASHTAG_FILE = "hashtag_file";
    private static final String HASHTAG_BAHOOSH = "hashtag_bahoosh";
    private static final String HASHTAG_CHANNEL = "hashtag_channel";
    private static final String MAX_SIZE_UPLOAD = "max_size_upload";
    private static final String FRG_FORUM_FIRST = "frg_first_forum";
    private static final String FRG_SEARCH_PRODUCT = "frg_search_product";
    private static final String FRG_SEARCH_FILE = "frg_search_file";
    private static final String FRG_SEARCH_FASL = "frg_search_fasl";
    private static final String FRG_SEARCH_TRAIN = "frg_search_train";
    private static final String FRG_FORUM_SECOND = "frg_first_second";
    private static final String FRG_FORUM_THIRD = "frg_first_third";
    private static final String FRG_PROFILE = "frg_profile";
    private static final String FRG_MYPAYMENT = "frg_mypayment";
    private static final String ITEM_LIST_COURSE_COMPLETE = "list_course_complete";
    private static final String ITEM_LIST_COURSE_DOING = "list_course_doing";
    private static final String ITEM_LIST_COURSE_ALL = "list_course_all";
    private static final String FRG_MYPEYMENT = "frg_mypeyment";
    private static final String CONFIG = "config";
    private static final String REY_CHAT_URL = "raychat_link";
    private static final String BASCKET_LIST_EXPIRE = "bascket_list_expire";
    private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";
    private static final String IS_FIRST_TIME_LAUNCH_MAIN = "IsFirstTimeLaunch_main";


    private SharedPreferences pref;
    private SharedPreferences prefsetting;
    public boolean isFirstTimeLaunchMain() {
        return pref.getBoolean(IS_FIRST_TIME_LAUNCH_MAIN, true);
    }

    public void setFirstTimeLaunchMain(boolean isFirstTime) {
        editor.putBoolean(IS_FIRST_TIME_LAUNCH_MAIN, isFirstTime);
        editor.commit();
    }

    public boolean isFirstTimeLaunch() {
        return pref.getBoolean(IS_FIRST_TIME_LAUNCH, true);
    }

    public void setFirstTimeLaunch(boolean isFirstTime) {
        editor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime);
        editor.commit();
    }

    public ClsSharedPreference(Context context) {
        pref = context.getSharedPreferences(PREFNAMELGIN, 0);
        prefsetting = context.getSharedPreferences(PRESETTING, 0);
        editorsetting = prefsetting.edit();
        editor = pref.edit();
    }

    public void set_Story_watch(boolean o1_0) {
        editor.putBoolean(STORY, o1_0);
        editor.commit();
    }

    public boolean get_story_watch() {
        return pref.getBoolean(STORY, false);
    }

    public void set_order_expire(boolean o1_0) {
        editor.putBoolean(BASCKET_LIST_EXPIRE, o1_0);
        editor.commit();
    }

    public boolean is_order_expire() {
        return pref.getBoolean(BASCKET_LIST_EXPIRE, false);
    }

    public void set_Ray_Chat_Url(String url) {
        editor.putString(REY_CHAT_URL, url);
        editor.commit();
    }

    public String get_Rey_Chat_Url() {
        return pref.getString(REY_CHAT_URL, "");
    }

    public void set_point(boolean o1_0) {
        editor.putBoolean(POINT, o1_0);
        editor.commit();
    }

    public void set_list_course_complete(boolean course_complete) {
        editor.putBoolean(ITEM_LIST_COURSE_COMPLETE, course_complete);
        editor.commit();
    }

    public boolean get_list_course_complete() {
        return pref.getBoolean(ITEM_LIST_COURSE_COMPLETE, false);
    }

    public void set_list_course_doing(boolean course_doing) {
        editor.putBoolean(ITEM_LIST_COURSE_DOING, course_doing);
        editor.commit();
    }

    public boolean get_list_course_doing() {
        return pref.getBoolean(ITEM_LIST_COURSE_DOING, true);
    }

    public void set_list_course_all(boolean course_doing) {
        editor.putBoolean(ITEM_LIST_COURSE_ALL, course_doing);
        editor.commit();
    }

    public boolean get_list_course_all() {
        return pref.getBoolean(ITEM_LIST_COURSE_ALL, false);
    }

    public boolean get_point() {
        return pref.getBoolean(POINT, false);
    }

    public int getIdProvince() {
        return prefsetting.getInt(ID_PROVINCE, 0);
    }

    public void setIdProvince(int id_province) {
        editorsetting.putInt(ID_PROVINCE, id_province);
        editorsetting.commit();
    }

    public int getcount_paket() {
        return prefsetting.getInt(COUNT_PACKET, 0);
    }

    public void setcount_paket(int id_province) {
        editorsetting.putInt(COUNT_PACKET, id_province);
        editorsetting.commit();
    }

    public void setStatus_change_all(boolean o1_0) {
        editor.putBoolean(ITEM_CHANGE_All, o1_0);
        editor.commit();
    }

    public boolean getStatus_change_all() {
        return pref.getBoolean(ITEM_CHANGE_All, false);
    }

    public void setStatus_hashtag_file(boolean o1_0) {
        editor.putBoolean(HASHTAG_FILE, o1_0);
        editor.commit();
    }

    public boolean getStatus_hashtag_file() {
        return pref.getBoolean(HASHTAG_FILE, false);
    }

    public void setStatus_hashtag_Bahoosh(boolean o1_0) {
        editor.putBoolean(HASHTAG_BAHOOSH, o1_0);
        editor.commit();
    }

    public boolean getFrgForumFirst() {
        return pref.getBoolean(FRG_FORUM_FIRST, false);
    }

    public void setFrgForumFirst(boolean o1_0) {
        editor.putBoolean(FRG_FORUM_FIRST, o1_0);
        editor.commit();
    }

    public boolean getFrgFasl() {
        return pref.getBoolean(FRG_SEARCH_FASL, false);
    }

    public void setFrgFasl(boolean o1_0) {
        editor.putBoolean(FRG_SEARCH_FASL, o1_0);
        editor.commit();
    }

    public boolean getFrgTrain() {
        return pref.getBoolean(FRG_SEARCH_TRAIN, false);
    }

    public void setFrgTrain(boolean o1_0) {
        editor.putBoolean(FRG_SEARCH_TRAIN, o1_0);
        editor.commit();
    }

    public boolean getFrgproduct() {
        return pref.getBoolean(FRG_SEARCH_PRODUCT, false);
    }

    public void setFrgproduct(boolean o1_0) {
        editor.putBoolean(FRG_SEARCH_PRODUCT, o1_0);
        editor.commit();
    }

    public boolean getFrgfile() {
        return pref.getBoolean(FRG_SEARCH_FILE, false);
    }

    public void setFrgfile(boolean o1_0) {
        editor.putBoolean(FRG_SEARCH_FILE, o1_0);
        editor.commit();
    }

    public boolean getFrgForumSecond() {
        return pref.getBoolean(FRG_FORUM_SECOND, false);
    }

    public void setFrgForumSecond(boolean o1_0) {
        editor.putBoolean(FRG_FORUM_SECOND, o1_0);
        editor.commit();
    }

    public boolean getFrgForumThird() {
        return pref.getBoolean(FRG_FORUM_THIRD, false);
    }

    public void setFrgForumThird(boolean o1_0) {
        editor.putBoolean(FRG_FORUM_THIRD, o1_0);
        editor.commit();
    }

    public boolean getStatus_hashtag_Bahoosh() {
        return pref.getBoolean(HASHTAG_BAHOOSH, false);
    }

    public void setStatus_hashtag_channel(boolean o1_0) {
        editor.putBoolean(HASHTAG_CHANNEL, o1_0);
        editor.commit();
    }

    public boolean getStatus_hashtag_channel() {
        return pref.getBoolean(HASHTAG_CHANNEL, false);
    }

    public int getIdCity() {
        return prefsetting.getInt(ID_CITY, 0);
    }

    public void submitIdCity(int id_city_param, String city_name) {
        editorsetting.putInt(ID_CITY, id_city_param);
        editorsetting.putString(NAME_CITY, city_name);
        editorsetting.commit();
    }

    public void setgender(int id_city_param) {
        editorsetting.putInt(GENDER, id_city_param);

        editorsetting.commit();
    }

    public int getgender() {
        return prefsetting.getInt(GENDER, 0);
    }

    public void setIdCity(int id_city_param) {
        editorsetting.putInt(ID_CITY, id_city_param);

        editorsetting.commit();
    }

    public boolean getSetStatustraining() {
        return pref.getBoolean(FRG_TRAINING, false);
    }


    public void SetStatustraining(boolean status) {
        editor.putBoolean(FRG_TRAINING, status);
        editor.commit();
    }

    public void SetStatusComment(boolean list_comment) {
        editor.putBoolean(LIST_COMMENT, list_comment);
        editor.commit();
    }

    public boolean getStatusComment() {
        return pref.getBoolean(LIST_COMMENT, false);
    }

    public boolean getSetStatuscomplete() {
        return pref.getBoolean(FRG_COMPLETE, false);
    }


    public void SetStatuscomplete(boolean status) {
        editor.putBoolean(FRG_COMPLETE, status);
        editor.commit();
    }


    public boolean getStatusAllType() {
        return pref.getBoolean(FRG_ALL_TYPE, false);
    }


    public void SetStatusAllType(boolean status) {
        editor.putBoolean(FRG_ALL_TYPE, status);
        editor.commit();
    }

    public boolean get_frg_mydiscuss() {
        return pref.getBoolean(FRG_MYDISCUSS, false);
    }


    public void set_frg_mydiscuss(boolean status) {
        editor.putBoolean(FRG_MYDISCUSS, status);
        editor.commit();
    }

    public boolean get_frg_profile() {
        return pref.getBoolean(FRG_PROFILE, false);
    }


    public void set_frg_profile(boolean status) {
        editor.putBoolean(FRG_PROFILE, status);
        editor.commit();
    }

    public boolean frg_mypeyment() {
        return pref.getBoolean(FRG_MYPAYMENT, false);
    }


    public void set_frg_mypeyment(boolean status) {
        editor.putBoolean(FRG_MYPAYMENT, status);
        editor.commit();
    }

    public boolean get_frg_mypayment() {
        return pref.getBoolean(FRG_MYPAYMENT, false);
    }


    public void set_frg_mypayment(boolean status) {
        editor.putBoolean(FRG_MYPAYMENT, status);
        editor.commit();
    }

    public boolean get_frg_alldiscuss() {
        return pref.getBoolean(FRG_AllDISCUSS, false);
    }


    public void set_frg_alldiscuss(boolean status) {
        editor.putBoolean(FRG_AllDISCUSS, status);
        editor.commit();
    }

    public boolean getSetStatusComments() {
        return pref.getBoolean(FRG_COMMENT, false);
    }


    public void SetStatusComments(boolean status) {
        editor.putBoolean(FRG_COMMENT, status);
        editor.commit();
    }

    public long getTimerCode() {
        return pref.getLong(KEY_TIMER_CODE, 0);
    }

    public void submitTimerCode(long status) {
        editor.putLong(KEY_TIMER_CODE, status);
        editor.commit();
    }


    public void setIdClassCurrent(String idClass) {
        editor.putString(ID_CLASS_CURRENT, idClass);
        editor.commit();
    }

    public String getIdClassCurrent() {
        return pref.getString(ID_CLASS_CURRENT, null);
    }

    public int get_max_size_upload() {
        return pref.getInt(MAX_SIZE_UPLOAD, 0);
    }

    public void set_max_size_upload(int size) {
        editor.putInt(MAX_SIZE_UPLOAD, size);
        editor.commit();
    }

    public String get_font_size() {
        return pref.getString(FONT_SIZE, "");
    }

    public void set_font_size(String font_size) {
        editor.putString(FONT_SIZE, font_size);
        editor.commit();
    }

    public boolean buy_file() {
        return pref.getBoolean(BUY_FILE, false);
    }


    public String get_api_token() {
        return pref.getString(API_TOKEN, "");
    }

    public void set_api_token(String api_token) {
        editor.putString(API_TOKEN, api_token);
        editor.commit();
    }

    public Boolean isLoggedIn() {
        return pref.getBoolean(IS_LOGIN, false);
    }


    public String get_uuid() {
        return pref.getString(UUID, "");
    }

    public void set_uuid(String uuid) {
        editor.putString(UUID, uuid);
        editor.commit();
    }

    public String get_limited_device() {
        return pref.getString(Limited_device, "");
    }

    public void set_limited_device(String limited_device) {
        editor.putString(Limited_device, limited_device);
        editor.commit();
    }

    public String get_uuidcourse() {
        return pref.getString(ID_FREE_COURSE, null);
    }

    public void set_uuidcourse(String uuid) {
        editor.putString(ID_FREE_COURSE, uuid);
        editor.commit();
    }

    public boolean get_repeat_off() {
        return pref.getBoolean(REPEAT_OFF, false);
    }

    public void set_repeat_off(boolean repeat) {
        editor.putBoolean(REPEAT_OFF, repeat);
        editor.commit();
    }

    public boolean get_repeat_one() {
        return pref.getBoolean(REPEAT_ONE, false);
    }

    public void set_repeat_one(boolean play) {
        editor.putBoolean(REPEAT_ONE, play);
        editor.commit();
    }

    public boolean get_repeat_all() {
        return pref.getBoolean(REPEAT_All, true);
    }

    public void set_repeat_all(boolean play) {
        editor.putBoolean(REPEAT_All, play);
        editor.commit();
    }

    public void SetPhotoProfile(String photo) {
        editor.putString(KEY_PHOTOPROFILE, photo);
        editor.commit();
    }

    public void updateUser(String userflname, String userllname) {
        editor.putBoolean(IS_LOGIN, true);
        editor.putString(KEY_USERFNAME, userflname);
        editor.putString(KEY_USERLNAME, userllname);
        editor.commit();
    }

    public String getName() {
        return pref.getString(KEY_USERFNAME, "");
    }

    public String getFamily() {
        return pref.getString(KEY_USERLNAME, "");
    }

    public void setBuycourse(boolean num) {
        editor.putBoolean(BUY, num);
        editor.commit();
    }

    public boolean getBuycourse() {
        return pref.getBoolean(BUY, false);
    }

    public void setBuytrain(boolean num) {
        editor.putBoolean(BUY_TRAIN, num);
        editor.commit();
    }

    public String getwallet() {
        return pref.getString(KEY_WALLET, "0");
    }

    public void setWallet(String wallet) {
        editor.putString(KEY_WALLET, wallet);
        editor.commit();
    }

    public String getwalletmin() {
        return pref.getString(KEY_WALLETMIN, "0");
    }

    public void setWalletmin(String walletmin) {
        editor.putString(KEY_WALLETMIN, walletmin);
        editor.commit();
    }


    public String getreagent_text() {
        return pref.getString(Reagent_text, "");
    }

    public void setreagent_text(String reagent_text) {
        editor.putString(Reagent_text, reagent_text);
        editor.commit();
    }

    public boolean getBuytrain() {
        return pref.getBoolean(BUY_TRAIN, false);
    }


    public void SetPathFile(String photo) {
        editor.putString(KEY_PATHFILE, photo);
        editor.commit();
    }

    public String getPathFile() {
        return pref.getString(KEY_PATHFILE, "");
    }

    public void SetPhotProfile(String photo) {
        editor.putString(KEY_PHOTOPROFILE, photo);
        editor.commit();
    }

    public String getPhotoProfile() {
        return pref.getString(KEY_PHOTOPROFILE, "");
    }


    public void set_phone(String phone) {
        editor.putString(PHONE, phone);
        editor.commit();
    }

    public String get_phone() {
        return pref.getString(PHONE, "");
    }

    public void set_tel(String tel) {
        editor.putString(TEL, tel);
        editor.commit();
    }

    public String get_tel() {
        return pref.getString(TEL, "");
    }

    public String getCodeRef() {
        return pref.getString(KEY_CODE_REAGENTS, "");
    }


    public String getTelephone() {
        return prefsetting.getString(KEY_TELEPHONE, null);
    }

    public void setContactUs(String email, String telePhone) {
        editorsetting.putString(KEY_EMAIL, email);
        editorsetting.putString(KEY_TELEPHONE, telePhone);
        editorsetting.commit();
    }

    public String get_about_us() {
        return prefsetting.getString(KEY_ABOUT_US, null);
    }

    public void set_about_us(String aboutUS) {
        editorsetting.putString(KEY_ABOUT_US, aboutUS);
        editorsetting.commit();
    }

    public String getTelegram() {
        return prefsetting.getString(KEY_TELEGRAM, "");
    }

    public void setTelegram(String telegram) {
        editorsetting.putString(KEY_TELEGRAM, telegram);
        editorsetting.commit();
    }

    public String getTelegramcanal() {
        return prefsetting.getString(KEY_TELEGRAMCANAL, "");
    }

    public void setTelegramcanal(String telegramcanal) {
        editorsetting.putString(KEY_TELEGRAMCANAL, telegramcanal);
        editorsetting.commit();
    }

    public String getInstagram() {
        return prefsetting.getString(KEY_INSTAGRAM, "");
    }

    public void setInstagram(String instagram) {
        editorsetting.putString(KEY_INSTAGRAM, instagram);
        editorsetting.commit();
    }

    public String getTwitter() {
        return prefsetting.getString(KEY_TWITTER, "");
    }

    public void setTwitter(String twitter) {
        editorsetting.putString(KEY_TWITTER, twitter);
        editorsetting.commit();
    }

    public String getFaceBook() {
        return prefsetting.getString(KEY_FACEBOOK, "");
    }

    public void setFaceBook(String facebook) {
        editorsetting.putString(KEY_FACEBOOK, facebook);
        editorsetting.commit();
    }

    public void setConfig(String config) {
        editorsetting.putString(CONFIG, config);
        editorsetting.commit();
    }

    public String getConfig() {
        return pref.getString(CONFIG, null);
    }


    public String getLinkVoiceComment() {
        return pref.getString(LINK_VOICE_COMMENT, null);
    }

    public void setLinkVoiceComment(String link) {
        editor.putString(LINK_VOICE_COMMENT, link);
        editor.commit();
    }

    public String getKeyUserflname() {
        return pref.getString(KEY_USERFNAME, null) + " " + pref.getString(KEY_USERLNAME, null);
    }

    public String getEmail() {
        return pref.getString(EMAIL, null);
    }

    public void setEmail(String email) {
        editor.putString(EMAIL, email);
        editor.commit();
    }

    public String getEmail_contact() {
        return prefsetting.getString(KEY_EMAIL, null);
    }

    public void setEmail_contact(String email) {
        editor.putString(KEY_EMAIL, email);
        editor.commit();
    }


    // Get status register
    public String getCodePhone() {
        return prefsetting.getString(CODE_PHONE, null);
    }

    public void submitCodePhone(String status) {
        editorsetting.putString(CODE_PHONE, status);
        editorsetting.commit();
    }

    public String getKeyPhone() {
        return pref.getString(KEY_PHONE, null);
    }

    public int getIsActive() {
        return pref.getInt(IS_ACTIVE, 1);
    }

    public void setIsActive(int isActive) {
        editor.putInt(IS_ACTIVE, isActive);
        editor.commit();
    }

    public void logoutUser() {
        editor.clear();
        editor.commit();
    }

    public void setVERSION_TEXT(String new_realese) {
        editorsetting.putString(NEW_RELEASE, new_realese);
        editorsetting.commit();
    }

    public String getVERSION_TEXT() {
        return prefsetting.getString(NEW_RELEASE, null);
    }


    public void setfav_train(boolean fav_train) {
        editor.putBoolean(FAV_TRAIN, fav_train);
        editor.commit();
    }

    public boolean getfav_train() {
        return pref.getBoolean(FAV_TRAIN, false);
    }

    public void setfav_course(boolean fav_course) {
        editor.putBoolean(FAV_COURSE, fav_course);
        editor.commit();
    }

    public boolean getfav_course() {
        return pref.getBoolean(FAV_COURSE, false);
    }

    public void setfav_file(boolean fav_file) {
        editor.putBoolean(FAV_FILE, fav_file);
        editor.commit();
    }

    public boolean getfav_file() {
        return pref.getBoolean(FAV_FILE, false);
    }

    public void setfav_product(boolean fav_product) {
        editor.putBoolean(FAV_SHOPPRODUCT, fav_product);
        editor.commit();
    }

    public boolean getfav_product() {
        return pref.getBoolean(FAV_SHOPPRODUCT, false);
    }


    public void setFavBlog(boolean favBlog) {
        editor.putBoolean(FAV_BLOG, favBlog);
        editor.commit();
    }

    public boolean getFavBlog() {
        return pref.getBoolean(FAV_BLOG, false);
    }

    public int setMessageCount(int messageCount) {
        editor.putInt(MESSAGE_COUNT, messageCount);
        editor.commit();
        return messageCount;
    }

    public int getMessageCount() {
        return pref.getInt(MESSAGE_COUNT, -1);
    }


    public void setLinkName(String link) {
        editor.putString(LINK_NAME, link);
        editor.commit();
    }

    public String getLinkName() {
        return pref.getString(LINK_NAME, null);
    }

    public void setLinkFile(String link) {
        editor.putString(LINK_FILE, link);
        editor.commit();
    }

    public String getLinkFile() {
        return pref.getString(LINK_FILE, "");
    }

    public void SetStatusmyQuestion_refresh(boolean o1_0) {
        editor.putBoolean(ITEM_MY_QUESTION_REFRESH, o1_0);
        editor.commit();
    }

    public boolean getStatusmyQuestion_refresh() {
        return pref.getBoolean(ITEM_MY_QUESTION_REFRESH, false);
    }

    public void SetStatusmyDiscuss(boolean o1_0) {
        editor.putBoolean(ITEM_MY_DISCUSS, o1_0);
        editor.commit();
    }

    public boolean getStatusmyDiscuss() {
        return pref.getBoolean(ITEM_MY_DISCUSS, false);
    }

    public void SetStatusallDiscuss(boolean o1_0) {
        editor.putBoolean(ITEM_ALL_DISCUSS, o1_0);
        editor.commit();
    }

    public boolean getStatusallDiscuss() {
        return pref.getBoolean(ITEM_ALL_DISCUSS, false);
    }

    public boolean get_like_dislike_my() {
        return pref.getBoolean(like_dislike_my, false);
    }

    public void Set_like_dislike_my(boolean seesion) {
        editor.putBoolean(like_dislike_my, seesion);
        editor.commit();
    }

    public boolean get_like_dislike_all() {
        return pref.getBoolean(like_dislike_all, false);
    }

    public void Set_like_dislike_all(boolean seesion) {
        editor.putBoolean(like_dislike_all, seesion);
        editor.commit();
    }

    public boolean get_like_dislike_second() {
        return pref.getBoolean(like_dislike_second, false);
    }

    public void Set_like_dislike_second(boolean seesion1) {
        editor.putBoolean(like_dislike_second, seesion1);
        editor.commit();
    }

    public boolean get_like_dislike_third() {
        return pref.getBoolean(like_dislike_third, false);
    }

    public void Set_like_dislike_third(boolean seesion2) {
        editor.putBoolean(like_dislike_third, seesion2);
        editor.commit();
    }

    public boolean get_like_dislike_search() {
        return pref.getBoolean(like_dislike_search, false);
    }

    public void Set_like_dislike_search(boolean seesion) {
        editor.putBoolean(like_dislike_search, seesion);
        editor.commit();
    }


    public void SetStatusQuestion(boolean list_question) {
        editor.putBoolean(LIST_QUESTION, list_question);
        editor.commit();
    }

    public boolean getStatusQuestion() {
        return pref.getBoolean(LIST_QUESTION, false);
    }


    public void SetStatusMYQuestion(boolean list_question) {
        editor.putBoolean(LIST_MYQUESTION, list_question);
        editor.commit();
    }

    public boolean getStatusMYQuestion() {
        return pref.getBoolean(LIST_MYQUESTION, false);
    }


    public void set_tell(String tell) {
        editor.putString(TELL, tell);
        editor.commit();
    }

    public String get_tell() {
        return pref.getString(TELL, "");
    }


    public String get_email() {
        return pref.getString(EMAIL, "");
    }

    public void set_email(String email) {
        editor.putString(EMAIL, email);
        editor.commit();
    }


    public void set_address(boolean address) {
        editor.putBoolean(Address, address);
        editor.commit();
    }

    public boolean get_address() {
        return pref.getBoolean(Address, false);
    }


    public void SetStatusVideoFile(boolean video_file) {
        editor.putBoolean(VIDEO_FILE, video_file);
        editor.commit();
    }

    public boolean getStatusVideoFile() {
        return pref.getBoolean(VIDEO_FILE, false);
    }

    public void SetStatusVoiceFile(boolean voice_file) {
        editor.putBoolean(VOICE_FILE, voice_file);
        editor.commit();
    }

    public boolean getStatusVoiceFile() {
        return pref.getBoolean(VOICE_FILE, false);
    }

    public void SetStatusPdfFile(boolean pdf_file) {
        editor.putBoolean(PDF_FILE, pdf_file);
        editor.commit();
    }

    public boolean getStatusPdfFile() {
        return pref.getBoolean(PDF_FILE, false);
    }


    public void set_file_url(String download_link) {
        editorsetting.putString(DOWNLOAD_LINK, download_link);
        editorsetting.commit();
    }

    public String get_file_url() {
        return prefsetting.getString(DOWNLOAD_LINK, "http://app.mahanteymouri.ir/mahant/public/");
    }

    public boolean getReload() {
        return pref.getBoolean(Reload_page, true);
    }

    public void setReload(boolean role) {
        editor.putBoolean(Reload_page, role);
        editor.commit();
    }

    public void SetStatusFavFile(boolean fav_file) {
        editor.putBoolean(Fav_File_Offline, fav_file);
        editor.commit();
    }

    public boolean getStatusFavFile() {
        return pref.getBoolean(Fav_File_Offline, false);
    }

    public void SetStatusUserFavoriteTrain(boolean user_favorite_train) {
        editor.putBoolean(User_Favorite_Train, user_favorite_train);
        editor.commit();
    }

    public boolean getStatusUserFavoriteTrain() {
        return pref.getBoolean(User_Favorite_Train, false);
    }


    public void SetStatusUserFavoriteCourse(boolean user_favorite_course) {
        editor.putBoolean(User_Favorite_Course, user_favorite_course);
        editor.commit();
    }

    public boolean getStatusUserFavoriteCourse() {
        return pref.getBoolean(User_Favorite_Course, false);
    }

    public void SetStatusUserFavoriteFile(boolean user_favorite_file) {
        editor.putBoolean(User_Favorite_Course, user_favorite_file);
        editor.commit();
    }

    public boolean getStatusUserFavoriteFile() {
        return pref.getBoolean(User_Favorite_File, false);
    }
}
