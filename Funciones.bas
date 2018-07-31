B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=StaticCode
Version=7.3
@EndOfDesignText@

Sub Process_Globals
	Public LOGUEADO	As Boolean
	Public LOGUEANDO	As Boolean
	Public USER_EMAIL As String
	Public USER_URL As String
	Public USER_NAME As String 
End Sub

'Sub hayConex() As Boolean
'	Dim sSocket As ServerSocket
'	If  sSocket.IsInitialized = False Then
'		sSocket.Initialize(8080, "sSocket")
'		sSocket.Close
'	End If
'	Dim res As String
'	res = sSocket.GetMyIP
'	Log(res)
'	If sSocket.GetMyIP = "127.0.0.1" Or res.StartsWith("fe80::") Then 'fe80::94c2:c6ff:fe42:b881%dummy0
'		Return False
'	Else
'		Return True
'	End If
'End Sub


'Sub FitCenterBitmap(Imv As ImageView, Dir As String, FileName As String)
''	Try
''	Private bmp As Bitmap = LoadBitmap(Dir, FileName)
''	Private cvs As Canvas
''	cvs.Initialize(Imv)
''   
''	Dim rectDest As Rect
''	Dim delta As Int
''	If bmp.Width / bmp.Height > Imv.Width / Imv.Height Then
''		delta = (Imv.Height - bmp.Height / bmp.Width * Imv.Width) / 2
''		rectDest.Initialize(0, delta,Imv.Width, Imv.Height - delta)
''	Else
''		delta = (Imv.Width - bmp.Width / bmp.Height * Imv.Height) / 2
''		rectDest.Initialize(delta, 0, Imv.Width - delta, Imv.Height)
''	End If
''	cvs.DrawBitmap(bmp, Null, rectDest)
''	Imv.Invalidate		
''	Catch
''		Log(LastException)
''	End Try
'
'End Sub



'Sub SendCall(PhoneNumber As String)
''	Dim p As PhoneCalls
''	Dim bd As BitmapDrawable
''	Dim ph As Phone
''	Dim tmpValue As String
''	Dim result As String
''	
''	bd = ph.GetResourceDrawable(17301659)
''	tmpValue="Desea llamar ahora al número: " & PhoneNumber
''	result=Msgbox2(tmpValue,"","Aceptar","Cancelar","",bd.Bitmap)
''	
''	If result=DialogResponse.POSITIVE Then
''		Try
''			StartActivity(p.Call(PhoneNumber))
''		Catch
''			If FlagAndroid6oSuperior Then
''				rp.CheckAndRequest(rp.PERMISSION_CALL_PHONE)
''			End If
''		End Try
''	End If
'End Sub