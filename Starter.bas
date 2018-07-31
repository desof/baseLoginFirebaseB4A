B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Service
Version=7.3
@EndOfDesignText@
#Region  Service Attributes 
	#StartAtBoot: False
	#ExcludeFromLibrary: True
#End Region

Sub Process_Globals
	Public auth As FirebaseAuth
	Public facebook As FacebookSdk
	Public UserActivos As String
End Sub

Sub Service_Create
	auth.Initialize("auth")						'<< INICIALIZA  
	facebook.Initialize	
End Sub

Sub Auth_SignedIn (User As FirebaseUser)
	
	Try
			Funciones.USER_NAME =(User.DisplayName)	'<< CARGO A LAS VARIABLES DEL MODULO FUNCIONES PARA USO POSTERIOR EN LA APP
			Funciones.USER_EMAIL=(User.Email)
			Funciones.USER_URL=(User.PhotoUrl)
			Funciones.LOGUEADO=True				'<< INDICA QUE YA HAY UN USEER LOGUEADO
			If Funciones.LOGUEANDO=True Then 		
			' SI ENTRA ES PORQUE SE ESTA REGISTRANDO EL LOGUEO POR PRIMERA VEZ YA QUE FUE ASIGNADA DESDE LA ACTVIDAD MAIN
				CallSubDelayed(Login, "SetState") 	
			Else	
				Log(LastException)
			End If
	Catch
		Log(LastException)
	End Try

End Sub

Sub Service_Start (StartingIntent As Intent)
'Msgbox ("listo","")
End Sub

'Return true to allow the OS default exceptions handler to handle the uncaught exception.
Sub Application_Error (Error As Exception, StackTrace As String) As Boolean
	Return True
End Sub

Sub Service_Destroy

End Sub




