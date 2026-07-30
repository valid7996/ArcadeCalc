# 🕹️ ArcadeCalc — ماشین حساب آرکید

<p align="center">
  <img src="https://img.shields.io/badge/Android-21%2B-brightgreen?logo=android" />
  <img src="https://img.shields.io/badge/Kotlin-1.9-blue?logo=kotlin" />
  <img src="https://img.shields.io/badge/نسخه-1.0-orange" />
  <img src="https://img.shields.io/badge/زبان-فارسی-red" />
</p>

یک ماشین حساب علمی با طراحی آرکید نئون، ساخته شده با **Android WebView** و **HTML/CSS/JS** خالص.

---

## ✨ ویژگی‌ها

| ویژگی | توضیح |
|-------|--------|
| 🎮 طراحی آرکید نئون | رابط گرافیکی با افکت‌های نئون و پس‌زمینه متحرک |
| 🔢 ماشین حساب علمی | sin، cos، tan، log، ln، √، x²، x³، n!، 1/x، \|x\| |
| 💥 افکت انفجار | ذرات رنگارنگ هنگام محاسبه نتیجه |
| 🎵 صداهای 8-بیتی | صداهای آرکید واقعی با Web Audio API |
| 📜 تاریخچه محاسبات | ذخیره، ویرایش، و استفاده مجدد از نتایج |
| 🏆 سیستم امتیاز و کامبو | امتیازدهی بر اساس سرعت و تعداد محاسبات |
| 📱 واکنش‌گرا | بهینه‌شده برای تمام اندازه‌های صفحه موبایل |
| 🌙 تم تاریک | طراحی کامل dark mode |

---

## 📋 پیش‌نیازها

- **Android Studio** Hedgehog (2023.1.1) یا بالاتر
- **JDK** نسخه 17 یا بالاتر
- **Android SDK** سطح 21 (Android 5.0) یا بالاتر
- **Kotlin** نسخه 1.9+
- اتصال اینترنت (برای بارگذاری فونت‌ها در اولین اجرا)

---

## 🚀 نصب و راه‌اندازی

### ۱. کلون کردن پروژه

```bash
git clone https://github.com/your-username/ArcadeCalc.git
cd ArcadeCalc
```

### ۲. باز کردن در Android Studio

```
File → Open → پوشه ArcadeCalc را انتخاب کنید
```

### ۳. همگام‌سازی Gradle

Android Studio به‌طور خودکار Gradle را همگام می‌کند.  
اگر نشد: `File → Sync Project with Gradle Files`

### ۴. اجرا روی دستگاه یا شبیه‌ساز

- **دستگاه واقعی**: USB Debugging را فعال کنید و دستگاه را وصل کنید
- **شبیه‌ساز**: یک AVD با API 21+ بسازید
- سپس دکمه **▶ Run** را بزنید

---

## 📦 ساخت APK نهایی

برای ساخت فایل APK قابل نصب:

```
Build → Build Bundle(s) / APK(s) → Build APK(s)
```

فایل APK در این مسیر قرار می‌گیرد:
```
app/build/outputs/apk/release/app-release-unsigned.apk
```

برای APK امضاشده:
```
Build → Generate Signed Bundle / APK
```

---

## 🗂️ ساختار پروژه

```
ArcadeCalc/
├── app/
│   ├── src/
│   │   └── main/
│   │       ├── assets/
│   │       │   └── index.html          ← رابط کاربری اصلی (HTML/CSS/JS)
│   │       ├── java/com/validbv/arcadecalc/
│   │       │   └── MainActivity.kt     ← Activity اصلی اندروید
│   │       ├── res/
│   │       │   ├── layout/
│   │       │   │   └── activity_main.xml
│   │       │   └── values/
│   │       │       └── themes.xml
│   │       └── AndroidManifest.xml
│   └── build.gradle.kts
└── README.md
```

---

## 🛠️ تکنولوژی‌ها

- **زبان**: Kotlin
- **رابط کاربری**: HTML5 + CSS3 + JavaScript (درون WebView)
- **صدا**: Web Audio API
- **فونت‌ها**: Press Start 2P (آرکید) + Vazirmatn (فارسی)
- **آیکون‌ها**: Font Awesome 6.5
- **حداقل SDK**: Android 5.0 (API 21)
- **هدف SDK**: Android 14 (API 34)

---

## 🎮 نحوه استفاده

1. **اعداد**: روی دکمه‌های عددی بزنید
2. **عملیات پایه**: `+` `-` `×` `÷` `%`
3. **عملیات علمی**: ردیف دکمه‌های آبی بالا (SIN، COS، LOG، ...)
4. **نتیجه**: دکمه `=` → انفجار رنگارنگ! 💥
5. **کامبو**: محاسبات پشت سر هم در کمتر از ۳ ثانیه → امتیاز بیشتر!
6. **تاریخچه**: نتایج قبلی را ببینید، ویرایش کنید یا دوباره استفاده کنید

---

## 📜 مجوز

این پروژه تحت مجوز MIT منتشر شده است.

---

ساخته شده توسط **valid_bv** 🎮
