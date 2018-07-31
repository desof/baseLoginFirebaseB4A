package desof.appbase.test.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_splash{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
views.get("imageview1").vw.setLeft((int)(0d));
views.get("imageview1").vw.setWidth((int)((100d / 100 * width) - (0d)));
views.get("imageview1").vw.setTop((int)(0d));
views.get("imageview1").vw.setHeight((int)((100d / 100 * height) - (0d)));

}
}