package desof.appbase.test;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class funciones {
private static funciones mostCurrent = new funciones();
public static Object getObject() {
    throw new RuntimeException("Code module does not support this method.");
}
 public anywheresoftware.b4a.keywords.Common __c = null;
public static boolean _logueado = false;
public static boolean _logueando = false;
public static String _user_email = "";
public static String _user_url = "";
public static String _user_name = "";
public desof.appbase.test.main _main = null;
public desof.appbase.test.login _login = null;
public desof.appbase.test.principal _principal = null;
public desof.appbase.test.starter _starter = null;
public desof.appbase.test.firebasemessaging _firebasemessaging = null;
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 2;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 3;BA.debugLine="Public LOGUEADO	As Boolean";
_logueado = false;
 //BA.debugLineNum = 4;BA.debugLine="Public LOGUEANDO	As Boolean";
_logueando = false;
 //BA.debugLineNum = 5;BA.debugLine="Public USER_EMAIL As String";
_user_email = "";
 //BA.debugLineNum = 6;BA.debugLine="Public USER_URL As String";
_user_url = "";
 //BA.debugLineNum = 7;BA.debugLine="Public USER_NAME As String";
_user_name = "";
 //BA.debugLineNum = 8;BA.debugLine="End Sub";
return "";
}
}
