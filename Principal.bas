B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Activity
Version=8.3
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: False
	#IncludeTitle: True
#End Region

Sub Process_Globals

End Sub

Sub Globals

	Private btnSignOut As Button
	Private Button1 As Button
End Sub

Sub Activity_Create(FirstTime As Boolean)
	
	Activity.LoadLayout("Main")			'<< CARGAMOS EL LAYOUT PRINCIPAL

End Sub

Sub Activity_Resume
	If Funciones.LOGUEADO=False Then btnSignOut.Enabled=False '<< NO HABILITAR POR QUE NO ESTA LOGUEADO
End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub


Sub btnSignOut_Click
 btnSignOut.Enabled=False
 Starter.auth.SignOutFromGoogle
End Sub

Sub Button1_Click
	ExitApplication
End Sub