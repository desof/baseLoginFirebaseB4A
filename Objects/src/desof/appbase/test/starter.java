package desof.appbase.test;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.objects.ServiceHelper;
import anywheresoftware.b4a.debug.*;

public class starter extends  android.app.Service{
	public static class starter_BR extends android.content.BroadcastReceiver {

		@Override
		public void onReceive(android.content.Context context, android.content.Intent intent) {
            BA.LogInfo("** Receiver (starter) OnReceive **");
			android.content.Intent in = new android.content.Intent(context, starter.class);
			if (intent != null)
				in.putExtra("b4a_internal_intent", intent);
            ServiceHelper.StarterHelper.startServiceFromReceiver (context, in, true, BA.class);
		}

	}
    static starter mostCurrent;
	public static BA processBA;
    private ServiceHelper _service;
    public static Class<?> getObject() {
		return starter.class;
	}
	@Override
	public void onCreate() {
        super.onCreate();
        mostCurrent = this;
        if (processBA == null) {
		    processBA = new BA(this, null, null, "desof.appbase.test", "desof.appbase.test.starter");
            if (BA.isShellModeRuntimeCheck(processBA)) {
                processBA.raiseEvent2(null, true, "SHELL", false);
		    }
            try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            processBA.loadHtSubs(this.getClass());
            ServiceHelper.init();
        }
        _service = new ServiceHelper(this);
        processBA.service = this;
        
        if (BA.isShellModeRuntimeCheck(processBA)) {
			processBA.raiseEvent2(null, true, "CREATE", true, "desof.appbase.test.starter", processBA, _service, anywheresoftware.b4a.keywords.Common.Density);
		}
        if (!true && ServiceHelper.StarterHelper.startFromServiceCreate(processBA, false) == false) {
				
		}
		else {
            processBA.setActivityPaused(false);
            BA.LogInfo("*** Service (starter) Create ***");
            processBA.raiseEvent(null, "service_create");
        }
        processBA.runHook("oncreate", this, null);
        if (true) {
			ServiceHelper.StarterHelper.runWaitForLayouts();
		}
    }
		@Override
	public void onStart(android.content.Intent intent, int startId) {
		onStartCommand(intent, 0, 0);
    }
    @Override
    public int onStartCommand(final android.content.Intent intent, int flags, int startId) {
    	if (ServiceHelper.StarterHelper.onStartCommand(processBA, new Runnable() {
            public void run() {
                handleStart(intent);
            }}))
			;
		else {
			ServiceHelper.StarterHelper.addWaitForLayout (new Runnable() {
				public void run() {
                    processBA.setActivityPaused(false);
                    BA.LogInfo("** Service (starter) Create **");
                    processBA.raiseEvent(null, "service_create");
					handleStart(intent);
                    ServiceHelper.StarterHelper.removeWaitForLayout();
				}
			});
		}
        processBA.runHook("onstartcommand", this, new Object[] {intent, flags, startId});
		return android.app.Service.START_NOT_STICKY;
    }
    public void onTaskRemoved(android.content.Intent rootIntent) {
        super.onTaskRemoved(rootIntent);
        if (true)
            processBA.raiseEvent(null, "service_taskremoved");
            
    }
    private void handleStart(android.content.Intent intent) {
    	BA.LogInfo("** Service (starter) Start **");
    	java.lang.reflect.Method startEvent = processBA.htSubs.get("service_start");
    	if (startEvent != null) {
    		if (startEvent.getParameterTypes().length > 0) {
    			anywheresoftware.b4a.objects.IntentWrapper iw = ServiceHelper.StarterHelper.handleStartIntent(intent, _service, processBA);
    			processBA.raiseEvent(null, "service_start", iw);
    		}
    		else {
    			processBA.raiseEvent(null, "service_start");
    		}
    	}
    }
	
	@Override
	public void onDestroy() {
        super.onDestroy();
        if (true) {
            BA.LogInfo("** Service (starter) Destroy (ignored)**");
        }
        else {
            BA.LogInfo("** Service (starter) Destroy **");
		    processBA.raiseEvent(null, "service_destroy");
            processBA.service = null;
		    mostCurrent = null;
		    processBA.setActivityPaused(true);
            processBA.runHook("ondestroy", this, null);
        }
	}

@Override
	public android.os.IBinder onBind(android.content.Intent intent) {
		return null;
	}public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.objects.FirebaseAuthWrapper _auth = null;
public static anywheresoftware.b4x.objects.FacebookSdkWrapper _facebook = null;
public static String _useractivos = "";
public desof.appbase.test.main _main = null;
public desof.appbase.test.login _login = null;
public desof.appbase.test.principal _principal = null;
public desof.appbase.test.firebasemessaging _firebasemessaging = null;
public desof.appbase.test.funciones _funciones = null;
public static boolean  _application_error(anywheresoftware.b4a.objects.B4AException _error,String _stacktrace) throws Exception{
 //BA.debugLineNum = 41;BA.debugLine="Sub Application_Error (Error As Exception, StackTr";
 //BA.debugLineNum = 42;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 43;BA.debugLine="End Sub";
return false;
}
public static String  _auth_signedin(anywheresoftware.b4a.objects.FirebaseAuthWrapper.FirebaseUserWrapper _user) throws Exception{
 //BA.debugLineNum = 17;BA.debugLine="Sub Auth_SignedIn (User As FirebaseUser)";
 //BA.debugLineNum = 19;BA.debugLine="Try";
try { //BA.debugLineNum = 20;BA.debugLine="Funciones.USER_NAME =(User.DisplayName)	'<< CAR";
mostCurrent._funciones._user_name = (_user.getDisplayName());
 //BA.debugLineNum = 21;BA.debugLine="Funciones.USER_EMAIL=(User.Email)";
mostCurrent._funciones._user_email = (_user.getEmail());
 //BA.debugLineNum = 22;BA.debugLine="Funciones.USER_URL=(User.PhotoUrl)";
mostCurrent._funciones._user_url = (_user.getPhotoUrl());
 //BA.debugLineNum = 23;BA.debugLine="Funciones.LOGUEADO=True				'<< INDICA QUE YA HA";
mostCurrent._funciones._logueado = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 24;BA.debugLine="If Funciones.LOGUEANDO=True Then";
if (mostCurrent._funciones._logueando==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 26;BA.debugLine="CallSubDelayed(Login, \"SetState\")";
anywheresoftware.b4a.keywords.Common.CallSubDelayed(processBA,(Object)(mostCurrent._login.getObject()),"SetState");
 }else {
 //BA.debugLineNum = 28;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.Log(BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(processBA)));
 };
 } 
       catch (Exception e12) {
			processBA.setLastException(e12); //BA.debugLineNum = 31;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.Log(BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(processBA)));
 };
 //BA.debugLineNum = 34;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 7;BA.debugLine="Public auth As FirebaseAuth";
_auth = new anywheresoftware.b4a.objects.FirebaseAuthWrapper();
 //BA.debugLineNum = 8;BA.debugLine="Public facebook As FacebookSdk";
_facebook = new anywheresoftware.b4x.objects.FacebookSdkWrapper();
 //BA.debugLineNum = 9;BA.debugLine="Public UserActivos As String";
_useractivos = "";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return "";
}
public static String  _service_create() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Service_Create";
 //BA.debugLineNum = 13;BA.debugLine="auth.Initialize(\"auth\")						'<< INICIALIZA";
_auth.Initialize(processBA,"auth");
 //BA.debugLineNum = 14;BA.debugLine="facebook.Initialize";
_facebook.Initialize();
 //BA.debugLineNum = 15;BA.debugLine="End Sub";
return "";
}
public static String  _service_destroy() throws Exception{
 //BA.debugLineNum = 45;BA.debugLine="Sub Service_Destroy";
 //BA.debugLineNum = 47;BA.debugLine="End Sub";
return "";
}
public static String  _service_start(anywheresoftware.b4a.objects.IntentWrapper _startingintent) throws Exception{
 //BA.debugLineNum = 36;BA.debugLine="Sub Service_Start (StartingIntent As Intent)";
 //BA.debugLineNum = 38;BA.debugLine="End Sub";
return "";
}
}
