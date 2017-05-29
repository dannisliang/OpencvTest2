#include <jni.h>
#include <string>


jstring nativeHello(JNIEnv* env) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}

extern "C" {

    JNIEXPORT jstring JNICALL
    Java_com_altotech_glass_api_opencvtest_MainActivity_stringFromJNI(
            JNIEnv *env,
            jobject /* this */) {
        return nativeHello(env);
    }

}

