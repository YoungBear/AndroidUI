##资源匹配有线顺序：

测试设备：

mdpi 先锋 mtk5507 39B700S density:1.0 1280*720

hdpi PPTV mstar 65T2 density:1.5 1920*1080

tvdpi PPTV mtk5508 50P density:1.33125 1920*1080

xxhdpi 魅族MX5 density:3.0 1080*1920



设备dpi    |    优先级
:----:    | :----:
mdpi      | mdpi>default>tvdpi>hdpi>xhdpi>ldpi>xxhdpi>xxxhdpi>nodpi
hdpi      | hdpi>tvdpi>xhdpi>xxhdpi>xxxhdpi>mdpi>default>nodpi>ldpi
tvdpi     | tvdpi>hdpi>xhdpi>mdpi>default>xxhdpi>xxxhdpi>ldpi>nodpi
xxhdpi    | xxhdpi>xxxhdpi>xhdpi>nodpi>hdpi>tvdpi>mdpi>default>ldpi


参考：
https://github.com/YoungBear/MyBlog/blob/master/Support_Multiple_Screens.md