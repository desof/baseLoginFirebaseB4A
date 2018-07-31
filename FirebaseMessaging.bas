B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Service
Version=7.3
@EndOfDesignText@
#Region  Service Attributes 
	#StartAtBoot: False	
#End Region

Sub Process_Globals
	 Private fm As FirebaseMessaging	
End Sub

Sub Service_Create	 
	 fm.Initialize("fm")	
	 fm.SubscribeToTopic("supermercados") ' SUBSCRIBIMOS A ESTE USUARIO AL TOPIC SUPERMERCADOS
	
End Sub

Public Sub SubscribeToTopics
	fm.SubscribeToTopic("sancrisapp") 	' SUBSCRIBIMOS A ESTE USUARIO AL TOPIC sancrisapp
End Sub

Sub Service_Start (StartingIntent As Intent)
	If fm.HandleIntent(StartingIntent) Then Return
End Sub

Sub fm_MessageArrived (Message As RemoteMessage)
   Log("Message arrived")
   Log($"Message data: ${Message.GetData}"$)
   Dim n As Notification
   n.Initialize
   n.Icon = "icon"
   n.SetInfo(Message.GetData.Get("title"), Message.GetData.Get("body"), Main)
   n.Notify(1)
 
End Sub

Sub Service_Destroy

End Sub
