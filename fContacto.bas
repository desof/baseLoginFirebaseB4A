B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Activity
Version=7.3
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: False
	#IncludeTitle: false
	#Extends: android.support.v7.app.AppCompatActivity
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.
	
End Sub

Sub Globals	
	Private ACToolBarDark2 As ACToolBarDark 'Este nombre debe ser el mismo de la barra del layout
	Dim ABHelper As ACActionBar
	Private tx1 As EditText
	Private tx2 As ACEditText
	Private tx3 As EditText
	Private cboTipo As ACSpinner
	Private imgUser As ImageView
	Dim IME As IME
	Private btEnviar As Button
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("Contacto")
	cboTipo.AddAll(Array As String ("Contacto", "Consulta", "Sugerencia", "Reporte Error", "Anunciar","Otro"))
	ACToolBarDark2.SetAsActionBar
	ACToolBarDark2.InitMenuListener
	ACToolBarDark2.Title="Formulario Contacto"
	ACToolBarDark2.SubTitle="dejá tu opinión"
	ABHelper.Initialize
	ABHelper.ShowUpIndicator = True
	tx1.Text=Funciones.USER_NAME
	
	If Funciones.USER_EMAIl <> Null Then
		tx2.Text=Funciones.USER_EMAIL
		tx2.Enabled=False
	Else
		tx2.Text=""
		tx2.Enabled=True
	End If	
	
	Dim links As Map
	links.Initialize

	Try
		If 	Funciones.hayConex Then
			links.Put(imgUser, Funciones.USER_URL)			
			'CallSubDelayed2(ImageDownloader, "Download", links)
		End If
	Catch
		Log(LastException)
	End Try
	
End Sub

Sub SaveImage	
	Dim out As OutputStream
	Dim tempbitmap As Bitmap
	out = File.OpenOutput(File.DirDefaultExternal, "usuario.jpg",  False)
	tempbitmap = imgUser.Bitmap
	tempbitmap.writeToStream(out, 100, "JPEG")
	out.Close
End Sub

Sub Filtro (Valor As String)
	Dim tmp As String 
	
	Select Valor
		Case "Micros"
			cboTipo.SelectedIndex=3
		Case "Contacto"
			cboTipo.SelectedIndex=0
		Case "Error"
			cboTipo.SelectedIndex=3
		Case "Anunciar"
			cboTipo.SelectedIndex=4
			tx3.Text="Quiero ser anunciante en SanCrisApp, enviarme más información."
		Case "Anunciar1"
			cboTipo.SelectedIndex=4
'			tmp="Rubro: " & CRLF &
'			tmp= tmp & "Categoría: " & CRLF &
'			tmp= tmp & "Nombre: " & CRLF &
'			tmp= tmp & "Domicilio: " & CRLF &
'			tmp= tmp & "Teléfono " & CRLF &
'			tmp= tmp & "Celular " & CRLF &
			'			tmp= tmp & "Web o facebbok "
			
			tmp= tmp & "Rubro: " & CRLF 
			tmp= tmp & "Categoría: " & CRLF
			tmp= tmp & "Nombre Negocio: " &  CRLF
			tmp= tmp & "Domicilio: " & CRLF
			tmp= tmp & "Teléfono: " &  CRLF
			tmp= tmp & "Celular: " &  CRLF
			tmp= tmp & "Email: " &  CRLF
			tmp= tmp & "WEB o Facebook: " &  CRLF
			tmp= tmp & "---------------------------" &  CRLF
			tmp= tmp & "borrar el que no correponda" &  CRLF
			tmp= tmp & "---------------------------" &  CRLF
			tmp= tmp & "Plan de Pago: 50 $ x mes (Normal)" &  CRLF
			tmp= tmp & "Plan de Pago: 100 $ x mes (Destacado con Imágen)" &  CRLF
			tmp= tmp & "---------------------" &  CRLF &  CRLF
			
			tx3.Text=tmp 
	End Select
	
End Sub

Sub cboTipo_ItemClick (Position As Int, Value As Object)
	Log("Spinner Item selected: " & Position & " - " & Value)
	
	If Value="Consulta" Then
			
	End If
	
End Sub

Sub  ACToolBarDark2_NavigationItemClick
	If (File.Exists(File.DirDefaultExternal, "usuario.db")) Then
		SaveImage
	End If
	Activity.Finish
End Sub

Sub Activity_Resume
	If tx2.Text="" Then
		'tx2.Enabled=False
		tx2.RequestFocus
	Else
		tx3.RequestFocus
	End If
End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

Sub Activity_KeyPress(KeyCode As Int) As Boolean
	If KeyCode = KeyCodes.KEYCODE_BACK Then
		If (File.Exists(File.DirDefaultExternal, "usuario.db")) Then
			SaveImage
		End If
		Activity.Finish
	Else If KeyCode = KeyCodes.KEYCODE_MENU Then
		Log(LastException)

	Else
		Return True   ' con esto vuelves al programa, si no pones nada sale de el
	End If
End Sub

Sub Initialize
End Sub

Sub ACToolBarDark2_MenuItemClick (Item As ACMenuItem)
	
End Sub

Sub btEnviar_Click
	'guarda si no existe la imagen del user actual
	If tx2.Text="" Then
		Msgbox ("Ingresa tu email por favor","Error de Email")
		'tx2.Enabled=False
		tx2.RequestFocus
		Return
	Else
		tx3.RequestFocus
	End If
	
	If Not(File.Exists(File.DirDefaultExternal, "usuario.jpg")) Then
		SaveImage
	End If

	If tx1.Text.Length<5 Then
		Msgbox("Ingrese su Nombre","Nombre Erroneo")
		tx1.RequestFocus
		btEnviar.Enabled=False
		Return 
	End If
	If tx2.Text.Length<8 Then
		Msgbox("Ingrese su Email","Email Erroneo")
		tx2.RequestFocus
		btEnviar.Enabled=False
		Return
	End If
	SendEmailDeSof
	Activity.Finish
End Sub

Sub SendEmailDeSof
	Dim SMTP1 As SMTP
	Dim server As String      : server= "smtp.gmail.com"
	Dim port As Int           : port= 465
	Dim emailname As String   : emailname="expototal2017@gmail.com"
	Dim password As String    : password="exposc123"
	Dim protocol As String    : protocol="SMTP"
	Dim destEmailAdress As String : destEmailAdress="expototal2017@gmail.com"'expototalsancristobal@hotmail.com
	'destEmailAdress= tx2.Text
	'Crear
	SMTP1.Initialize(server, port, emailname, password, protocol)
	SMTP1.UseSSL = True
	' Enviar
	'SMTP1.To.Add (Main.EmailUser)
	
	If (File.Exists(File.DirDefaultExternal, "usuario.jpg")) Then
		''Msgbox("agregar","")
		SMTP1.AddAttachment(File.DirDefaultExternal,"usuario.jpg")
	End If
	If tx2.Text.Length<5 Then
		'
	Else
'		emailname=tx2.Text
	End If
	
	SMTP1.To.Add(destEmailAdress)
	SMTP1.Subject = "Contacto a traves de SanCrisApp"
	tmp= cboTipo.SelectedItem  & " :" & CRLF & CRLF
	tmp=tmp &  tx3.Text & CRLF  & CRLF
	tmp=tmp & "Nombre: " & tx1.Text & CRLF 
	tmp=tmp & "Email: " & tx2.Text & CRLF & CRLF
	tmp=tmp & "Saludos cordiales!"
	
	SMTP1.Body =tmp
	Try
		SMTP1.Send
		Msgbox ("Se ha enviado Correctamente su mensaje." & CRLF & "Nos pondremos en contacto a la brevedad."& CRLF & "¡Muchas Gracias!","Contacto Exitoso")
	Catch
		IME.HideKeyboard
		Msgbox(LastException,"Fallo el envió")
	End Try
		
End Sub

Sub tx3_TextChanged (Old As String, New As String)
	If tx3.Text.Length>3 Then
		btEnviar.Enabled=True
	Else
		btEnviar.Enabled=False
	End If
End Sub

Sub tx2_TextChanged (Old As String, New As String)
	If tx3.Text.Length>3 Then
		btEnviar.Enabled=True
	Else
		btEnviar.Enabled=False
	End If
End Sub

Sub tx1_TextChanged (Old As String, New As String)
	If tx3.Text.Length>3 Then
		btEnviar.Enabled=True
	Else
		btEnviar.Enabled=False
	End If
End Sub