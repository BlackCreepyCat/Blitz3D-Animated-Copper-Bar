
Graphics 800,600,32,2

;// SETUP AND IMAGE AND DRAW A COLORED BAR INTO IT

copperbar = CreateImage(800,32)                ; Create the image used for the bar
SetBuffer ImageBuffer(copperbar)        ; And point all drawing commands to the new Image

For i = 0 To 15                                                ; Loop through the values 0 to 31
        Color 0,0,i Shl 4                                ; Set the color to a blue
        Line 0,i,799,i                                        ; Draw a line in that colour
        Line 0,31-i,799,31-i                        ; And yet another line in the same colour, but from the buttom and up
Next

;// SET THE STARTING ANGLES AND ADDITIONS FOR THE EFFECT

angle1 = 0
angle2 = 30
angleadd1 = 2
angleadd2 = 3

SetBuffer BackBuffer() 
While Not KeyHit(1) 

;// draw the copperbars onto the screen in a sinus pattern

b=angle1
c=angle2
For a=0 To 15
        DrawImage copperbar,0,300+Sin(b)*128+Sin(c)*64
        b=b+8
        c=c+12
Next

;// here we update the angles; the number determines how often this is done

If angleupd + 15 <= MilliSecs() Then
        angleupd = MilliSecs()

        ; change the starting angles
        angle1 = angle1 + angleadd1
        If angle1 > 359 Then angle1 = angle1 - 360
        angle2 = angle2 + angleadd2
        If angle2 > 359 Then angle2 = angle2 - 360
        
        End If

        ; every once in a while change the pattern
If patternupd + 50 <= MilliSecs() Then
        patternupd = MilliSecs()
        ; randomly determine which add value to change
        r = Rnd(100)
        If r < 50 Then
        angadd1 = Rnd(3)
        Else
        angleadd2 = Rnd(3)
        End If
End If

Flip
Cls
Wend
End


;~IDEal Editor Parameters:
;~C#Blitz3D