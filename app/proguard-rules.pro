# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

#============= Hilt / Dagger Rules =============
# Hilt uses generated code that must be kept. These rules are standard for Hilt.
-keep class dagger.hilt.internal.aggregatedroot.codegen.*
-keep class *.**_HiltComponents_*
-keep class *.**_GeneratedInjector
-keep @dagger.hilt.android.HiltAndroidApp class *
-keep @dagger.hilt.android.WithFragmentBindings class *  # <-- CORRECTED SYNTAX
-keep @interface dagger.Module # Keep the Module annotation interface itself
-keep @interface dagger.hilt.InstallIn # Keep the InstallIn annotation interface itself


#============= Room Rules =============
# If you use Room, you need to keep the entity and DAO classes.
# Replace 'com.example.kotlinmvvmcleanhiltjetpackcompose.data.local.entity' with your actual entity package.
-keep class com.example.kotlinmvvmcleanhiltjetpackcompose.data.local.entity.** { *; }

#============= Jetpack Compose Rules =============
# NOTE: Most Compose rules are now included automatically by the library.
# The rules below have been removed as they are no longer needed and cause errors.
# -keepclassmembers class * { @androidx.compose.runtime.Composable <methods>; }
# -keep class androidx.compose.runtime.internal.ComposableLambda { *; }
# -keep class androidx.compose.runtime.internal.ComposableLambdaImpl { *; }
# -keep class androidx.compose.runtime.internal.PersistentCompositionLocal { *; }
# -keepclassmembers class * extends androidx.compose.runtime.Composer { <methods>; }

#============= General Model/Data Class Rules =============
# It's a good practice to keep your data/model classes that are serialized/deserialized.
# Replace 'com.example.kotlinmvvmcleanhiltjetpackcompose.data.model' with your actual model package name.
-keep class com.example.kotlinmvvmcleanhiltjetpackcompose.data.model.** { *; }

# A rule that is too broad and will prevent obfuscation
-keep class com.example.kotlinmvvmcleanhiltjetpackcompose.** { *; }
