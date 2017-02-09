#include <jni.h>
#include <string>

extern "C"
jstring
Java_com_tyagiabhinav_mvprxapp_MVPRxAPP_getAuthToken(
        JNIEnv *env,
        jobject /* this */) {
    std::string token = "R0IxWlpMUVBNRk1HWEVSWlBMR0ZFQlJQMVVOV1dBSDNRUTVRSElEWElVSVBKNDVFJnY9MjAxNjEyMjk=";//GB1ZZLQPMFMGXERZPLGFEBRP1UNWWAH3QQ5QHIDXIUIPJ45E&v=20161229";
    return env->NewStringUTF(token.c_str());
}