##资源匹配优先顺序：

##测试设备

Name                 |    Resolution
:----:               |    :----:
FWVGA 5.4            |    480x854 mdpi
Android5.1 Nexus7    |    800x1280 tvdpi
Nexus S API 10       |    480x800 hdpi
Nexus 10             |    2560x1600 xhpi
Nexus 5              |    1080x1920 xxhdpi



设备dpi    |    优先级
:----:    | :----:
mdpi      | mdpi>default>tvdpi>hdpi>xhdpi>ldpi>xxhdpi>xxxhdpi>nodpi
tvdpi     | tvdpi>hdpi>xhdpi>mdpi>default>xxhdpi>xxxhdpi>ldpi>nodpi
hdpi      | hdpi>tvdpi>xhdpi>xxhdpi>xxxhdpi>mdpi>default>nodpi>ldpi
xhdpi     | xhdpi>xxhdpi>xxxhdpi>hdpi>tvdpi>nodpi>mdpi>default>ldpi
xxhdpi    | xxhdpi>xxxhdpi>xhdpi>nodpi>hdpi>tvdpi>mdpi>default>ldpi


参考：
https://github.com/YoungBear/MyBlog/blob/master/Support_Multiple_Screens.md
