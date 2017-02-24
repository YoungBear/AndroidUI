##资源匹配优先顺序：


设备dpi    |    优先级
:----:    | :----:
mdpi      | mdpi>default>tvdpi>hdpi>xhdpi>ldpi>xxhdpi>xxxhdpi>nodpi
hdpi      | hdpi>tvdpi>xhdpi>xxhdpi>xxxhdpi>mdpi>default>nodpi>ldpi
tvdpi     | tvdpi>hdpi>xhdpi>mdpi>default>xxhdpi>xxxhdpi>ldpi>nodpi
xxhdpi    | xxhdpi>xxxhdpi>xhdpi>nodpi>hdpi>tvdpi>mdpi>default>ldpi


参考：
https://github.com/YoungBear/MyBlog/blob/master/Support_Multiple_Screens.md