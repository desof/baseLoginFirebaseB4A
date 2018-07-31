package desof.appbase.test.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_login{

public static void LS_320x480_1(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
//BA.debugLineNum = 1;BA.debugLine="imgLogo.Left =50%X - (imgLogo.Width /2)"[login/320x480,scale=1]
views.get("imglogo").vw.setLeft((int)((50d / 100 * width)-((views.get("imglogo").vw.getWidth())/2d)));
//BA.debugLineNum = 2;BA.debugLine="Label1.SetLeftAndRight(0,100%X)"[login/320x480,scale=1]
views.get("label1").vw.setLeft((int)(0d));
views.get("label1").vw.setWidth((int)((100d / 100 * width) - (0d)));
//BA.debugLineNum = 3;BA.debugLine="Label1.Top=imgLogo.Bottom +2dip"[login/320x480,scale=1]
views.get("label1").vw.setTop((int)((views.get("imglogo").vw.getTop() + views.get("imglogo").vw.getHeight())+(2d * scale)));
//BA.debugLineNum = 5;BA.debugLine="Label3.SetLeftAndRight(0,100%X)"[login/320x480,scale=1]
views.get("label3").vw.setLeft((int)(0d));
views.get("label3").vw.setWidth((int)((100d / 100 * width) - (0d)));
//BA.debugLineNum = 6;BA.debugLine="Label3.Top=Label1.Bottom + 5dip"[login/320x480,scale=1]
views.get("label3").vw.setTop((int)((views.get("label1").vw.getTop() + views.get("label1").vw.getHeight())+(5d * scale)));
//BA.debugLineNum = 8;BA.debugLine="btnSignInGoogle.Left= 50%X - (btnSignInGoogle.Width /2)"[login/320x480,scale=1]
views.get("btnsigningoogle").vw.setLeft((int)((50d / 100 * width)-((views.get("btnsigningoogle").vw.getWidth())/2d)));
//BA.debugLineNum = 9;BA.debugLine="btnSignInFacebook.Left= 50%X - (btnSignInGoogle.Width /2)"[login/320x480,scale=1]
views.get("btnsigninfacebook").vw.setLeft((int)((50d / 100 * width)-((views.get("btnsigningoogle").vw.getWidth())/2d)));
//BA.debugLineNum = 10;BA.debugLine="btNoUsar.Left= 50%X - (btnSignInGoogle.Width /2)"[login/320x480,scale=1]
views.get("btnousar").vw.setLeft((int)((50d / 100 * width)-((views.get("btnsigningoogle").vw.getWidth())/2d)));
//BA.debugLineNum = 12;BA.debugLine="btnSignInGoogle.Top = Label3.Bottom + 20dip"[login/320x480,scale=1]
views.get("btnsigningoogle").vw.setTop((int)((views.get("label3").vw.getTop() + views.get("label3").vw.getHeight())+(20d * scale)));
//BA.debugLineNum = 13;BA.debugLine="btnSignInFacebook.Top =btnSignInGoogle.Bottom + 15dip"[login/320x480,scale=1]
views.get("btnsigninfacebook").vw.setTop((int)((views.get("btnsigningoogle").vw.getTop() + views.get("btnsigningoogle").vw.getHeight())+(15d * scale)));
//BA.debugLineNum = 14;BA.debugLine="btNoUsar.Top= btnSignInFacebook.Bottom + 15dip"[login/320x480,scale=1]
views.get("btnousar").vw.setTop((int)((views.get("btnsigninfacebook").vw.getTop() + views.get("btnsigninfacebook").vw.getHeight())+(15d * scale)));
//BA.debugLineNum = 16;BA.debugLine="lbpie.SetLeftAndRight (0,100%x)"[login/320x480,scale=1]
views.get("lbpie").vw.setLeft((int)(0d));
views.get("lbpie").vw.setWidth((int)((100d / 100 * width) - (0d)));
//BA.debugLineNum = 17;BA.debugLine="lbpie.SetTopAndBottom(90%y,100%y)"[login/320x480,scale=1]
views.get("lbpie").vw.setTop((int)((90d / 100 * height)));
views.get("lbpie").vw.setHeight((int)((100d / 100 * height) - ((90d / 100 * height))));

}
public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
views.get("panellogin").vw.setLeft((int)(0d));
views.get("panellogin").vw.setWidth((int)((100d / 100 * width) - (0d)));
views.get("panellogin").vw.setTop((int)(0d));
views.get("panellogin").vw.setHeight((int)((100d / 100 * height) - (0d)));

}
}