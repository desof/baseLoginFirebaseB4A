B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Activity
Version=7.3
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: False
	#IncludeTitle: True
#End Region

Sub Process_Globals
End Sub

Sub Globals
	Private btNoUsar As Button
	Private btnSignInFacebook As Button
	Private btnSignInGoogle As Button
	Private btnSignOut As Button
End Sub

Sub Activity_Create(FirstTime As Boolean)	
	Activity.LoadLayout("Login")				'<< CARGAMOS EL LAYOUT DEL LOGIN
End Sub

Sub Initialize
End Sub

Sub Activity_Resume
'	SetState
End Sub

Sub Activity_KeyPress(KeyCode As Int) As Boolean
	If KeyCode = KeyCodes.KEYCODE_BACK  Then
		Salir				'<< SALIMOS DE LA APP
	Else
		Return True
	End If
End Sub
Sub Activity_Pause (UserClosed As Boolean)
	
End Sub

Sub btnSignInFacebook_Click
	Starter.facebook.SignIn				'<< LLAMAMOS AL LOGIN DE FACEBOOK
End Sub

Sub btnSignInGoogle_Click
	Starter.auth.SignInWithGoogle				'<< LLAMAMOS AL LOGIN DE GOOGLE
End Sub

Sub btnSignOut_Click
	Starter.auth.SignOutFromGoogle 			'<< QUITAMOS EL LOGUEO ACTIVO DE GOOGLE
	Starter.facebook.SignOut				'<< QUITAMOS EL LOGUEO ACTIVO DE FACEBOOK
End Sub
	
Sub SetState
	If Funciones.LOGUEADO Then		
		StartActivity(Principal)			'<< LLAMAMOS A LA ACTIVIDAD PRINCIPAL YA QUE EL LOGUEO FUE EXITOSO								
		Activity.Finish					'<< FINALIZAMOS LA ACTIVIDAD
	End If	
End Sub


Sub btNoUsar_Click
	Salir
End Sub

Sub Salir
	Dim bd As BitmapDrawable
	Dim PH As Phone
	Dim tmpValue As String
	Dim result As String
	
	bd = PH.GetResourceDrawable(17301659)
	tmpValue="Desea salir de la aplicación?: "
	result=Msgbox2(tmpValue,"","Aceptar","Cancelar","",bd.Bitmap)

	If result=DialogResponse.POSITIVE Then
		' mp.Stop
		ExitApplication
	Else
		Return
	End If
End Sub

