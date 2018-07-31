B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Activity
Version=7.3
@EndOfDesignText@

#Region  Activity Attributes 
	#FullScreen: True
	#IncludeTitle: False
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.
	'Private rp As RuntimePermissions
	'////////////////////////////
	
	Dim slides As List
	'////////////////////////////
End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.
	'Dim Slider As Slider
	
	'Dim imSlider As ImageSlider
	'////////////////////////
'	Private slider As ImageSlider
'	Private indicator As PagerIndicator
	'Private currentImage As SlideImage
	'///////////////////////////////
	Private indicator As PagerIndicator
	Private slider As ImageSlider
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("Test")
	'Activity.LoadLayout("Galeria")		
		
	CargaImagenes
End Sub


Sub CargaImagenes()
'Try	
	If Funciones.hayConex Then
'		
		slides.Initialize
						
		Dim ruta As String
		If File.ExternalWritable Then
			ruta= File.DirDefaultExternal
		Else
			ruta=File.DirInternal
		End If
		
		File.MakeDir(ruta, "baner")
			
'''		Dim flist As List
'''			
'''		flist = File.ListFiles(File.DirDefaultExternal&"/baner/")
			
		Dim sl As SlideImage
		sl.Initialize
			 
		sl.name = "1"
		sl.path = "http://www.desoft.com.ar/expototal/baner/1.jpg"
		slides.Add(sl)
		slider.addSliderUrl("","http://www.desoft.com.ar/expototal/baner/1.jpg",slider.CenterInside)
		''
		sl.name = "2"
		sl.path = "http://www.desoft.com.ar/expototal/baner/2.jpg"
		slides.Add(sl)
		slider.addSliderUrl("","http://www.desoft.com.ar/expototal/baner/2.jpg",slider.CenterInside)
		''
		sl.name = "3"
		sl.path = "http://www.desoft.com.ar/expototal/baner/3.jpg"
		slides.Add(sl)
		slider.addSliderUrl("","http://www.desoft.com.ar/expototal/baner/3.jpg",slider.CenterInside)
		''
		sl.name = "4"
		sl.path = "http://www.desoft.com.ar/expototal/baner/4.jpg"
		slides.Add(sl)
		slider.addSliderUrl("","http://www.desoft.com.ar/expototal/baner/4.jpg",slider.CenterInside)
		
		''
		sl.name = "5"
		sl.path = "http://www.desoft.com.ar/expototal/baner/5.jpg"
		slides.Add(sl)
		slider.addSliderUrl("","http://www.desoft.com.ar/expototal/baner/5.jpg",slider.CenterInside)
		
		sl.name = "6"
		sl.path = "http://www.desoft.com.ar/expototal/baner/6.jpg"
		slides.Add(sl)
		slider.addSliderUrl("","http://www.desoft.com.ar/expototal/baner/6.jpg",slider.CenterInside)
		
		sl.name = "7"
		sl.path = "http://www.desoft.com.ar/expototal/baner/7.jpg"
		slides.Add(sl)
		slider.addSliderUrl("","http://www.desoft.com.ar/expototal/baner/7.jpg",slider.CenterInside)
			
		slider.Duration=7
		slider.PresetTransformer2 = slider.Accordion'Stack'Fade'Foreground2Background'Fade'DepthPage'Stack'FlipHorizontal 'Accordion

		Log(slider.CurrentPosition)
		slider.startAutoCycle2 (1500,5000,True)
		'DSFloatingActionButton1.Tag=DSFloatingActionButton1.Top
'			'dsCompartir.Tag=dsCompartir.Top
'		
	Else
		indicator.Visible=False
		slider.Visible=False
	End If
'	
'	Catch
'			Msgbox(LastException,"")
'	End Try
End Sub

Sub Activity_KeyPress(KeyCode As Int) As Boolean
		
'	'If KeyCode = KeyCodes.KEYCODE_BACK Then
'		Dim p As PhoneWakeState
'		p.ReleaseKeepAlive
	'End If
End Sub

Sub Activity_Resume
'	Dim p As PhoneWakeState
'	p.KeepAlive(True)
End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub
 

Sub Slider_onPageScrollStateChanged(state As Int)
	
End Sub

Sub Slider_onPageScrolled(position As Int, positionOffset As Float, positionOffsetPixels As Int)
	
End Sub

Sub Slider_onPageSelected(position As Int)
	
End Sub

Sub Slider_onSliderClick()
	
End Sub

Sub indicator_onClick()
	
End Sub