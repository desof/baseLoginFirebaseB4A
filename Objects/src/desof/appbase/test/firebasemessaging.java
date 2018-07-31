package desof.appbase.test;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.objects.ServiceHelper;
import anywheresoftware.b4a.debug.*;

public class firebasemessaging extends  android.app.Service{
	public static class firebasemessaging_BR extends android.content.BroadcastReceiver {

		@Override
		public void onReceive(android.content.Context context, android.content.Intent intent) {
            BA.LogInfo("** Receiver (firebasemessaging) OnReceive **");
			android.content.Intent in = new android.content.Intent(context, firebasemessaging.class);
			if (intent != null)
				in.putExtra("b4a_internal_intent", intent);
            ServiceHelper.StarterHelper.startServiceFromReceiver (context, in, false, BA.class);
		}

	}
    static firebasemessaging mostCurrent;
	public static BA processBA;
    private ServiceHelper _service;
    public static Class<?> getObject() {
		return firebasemessaging.class;
	}
	@Override
	public void onCreate() {
        super.onCreate();
        mostCurrent = this;
        if (processBA == null) {
		    processBA = new BA(this, null, null, "desof.appbase.test", "desof.appbase.test.firebasemessaging");
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
			processBA.raiseEvent2(null, true, "CREATE", true, "desof.appbase.test.firebasemessaging", processBA, _service, anywheresoftware.b4a.keywords.Common.Density);
		}
        if (!false && ServiceHelper.StarterHelper.startFromServiceCreate(processBA, false) == false) {
				
		}
		else {
            processBA.setActivityPaused(false);
            BA.LogInfo("*** Service (firebasemessaging) Create ***");
            processBA.raiseEvent(null, "service_create");
        }
        processBA.runHook("oncreate", this, null);
        if (false) {
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
                    BA.LogInfo("** Service (firebasemessaging) Create **");
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
        if (false)
            processBA.raiseEvent(null, "service_taskremoved");
            
    }
    private void handleStart(android.content.Intent intent) {
    	BA.LogInfo("** Service (firebasemessaging) Start **");
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
        if (false) {
            BA.LogInfo("** Service (firebasemessaging) Destroy (ignored)**");
        }
        else {
            BA.LogInfo("** Service (firebasemessaging) Destroy **");
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
public static anywheresoftware.b4a.objects.FirebaseNotificationsService.FirebaseMessageWrapper _fm = null;
public desof.appbase.test.main _main = null;
public desof.appbase.test.login _login = null;
public desof.appbase.test.principal _principal = null;
public desof.appbase.test.starter _starter = null;
public desof.appbase.test.funciones _funciones = null;
public static String  _fm_messagearrived(anywheresoftware.b4a.objects.FirebaseNotificationsService.RemoteMessageWrapper _message) throws Exception{
anywheresoftware.b4a.objects.NotificationWrapper _n = null;
 //BA.debugLineNum = 23;BA.debugLine="Sub fm_MessageArrived (Message As RemoteMessage)";
 //BA.debugLineNum = 24;BA.debugLine="Log(\"Message arrived\")";
anywheresoftware.b4a.keywords.Common.Log("Message arrived");
 //BA.debugLineNum = 25;BA.debugLine="Log($\"Message data: ${Message.GetData}\"$)";
anywheresoftware.b4a.keywords.Common.Log(("Message data: "+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_message.GetData().getObject()))+""));
 //BA.debugLineNum = 26;BA.debugLine="Dim n As Notification";
_n = new anywheresoftware.b4a.objects.NotificationWrapper();
 //BA.debugLineNum = 27;BA.debugLine="n.Initialize";
_n.Initialize();
 //BA.debugLineNum = 28;BA.debugLine="n.Icon = \"icon\"";
_n.setIcon("icon");
 //BA.debugLineNum = 29;BA.debugLine="n.SetInfo(Message.GetData.Get(\"title\"), Message";
_n.SetInfoNew(processBA,BA.ObjectToCharSequence(_message.GetData().Get((Object)("title"))),BA.ObjectToCharSequence(_message.GetData().Get((Object)("body"))),(Object)(mostCurrent._main.getObject()));
 //BA.debugLineNum = 30;BA.debugLine="n.Notify(1)";
_n.Notify((int) (1));
 //BA.debugLineNum = 32;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 5;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 6;BA.debugLine="Private fm As FirebaseMessaging";
_fm = new anywheresoftware.b4a.objects.FirebaseNotificationsService.FirebaseMessageWrapper();
 //BA.debugLineNum = 7;BA.debugLine="End Sub";
return "";
}
public static String  _service_create() throws Exception{
 //BA.debugLineNum = 9;BA.debugLine="Sub Service_Create";
 //BA.debugLineNum = 10;BA.debugLine="fm.Initialize(\"fm\")";
_fm.Initialize(processBA,"fm");
 //BA.debugLineNum = 11;BA.debugLine="fm.SubscribeToTopic(\"supermercados\") ' SUBSCRIBI";
_fm.SubscribeToTopic("supermercados");
 //BA.debugLineNum = 13;BA.debugLine="End Sub";
return "";
}
public static String  _service_destroy() throws Exception{
 //BA.debugLineNum = 34;BA.debugLine="Sub Service_Destroy";
 //BA.debugLineNum = 36;BA.debugLine="End Sub";
return "";
}
public static String  _service_start(anywheresoftware.b4a.objects.IntentWrapper _startingintent) throws Exception{
 //BA.debugLineNum = 19;BA.debugLine="Sub Service_Start (StartingIntent As Intent)";
 //BA.debugLineNum = 20;BA.debugLine="If fm.HandleIntent(StartingIntent) Then Return";
if (_fm.HandleIntent((android.content.Intent)(_startingintent.getObject()))) { 
if (true) return "";};
 //BA.debugLineNum = 21;BA.debugLine="End Sub";
return "";
}
public static String  _subscribetotopics() throws Exception{
 //BA.debugLineNum = 15;BA.debugLine="Public Sub SubscribeToTopics";
 //BA.debugLineNum = 16;BA.debugLine="fm.SubscribeToTopic(\"sancrisapp\") 	' SUBSCRIBIMOS";
_fm.SubscribeToTopic("sancrisapp");
 //BA.debugLineNum = 17;BA.debugLine="End Sub";
return "";
}
}
