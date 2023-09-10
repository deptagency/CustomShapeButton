package com.example.customshapebutton

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import kotlin.math.PI
import kotlin.math.atan
import kotlin.math.tan
import kotlin.math.sin
import kotlin.math.cos

class TriangleShape(private val roundRadius: Float) : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ) = Outline.Generic(
        Path().apply {
            val CR = size.width
            val AR = size.height / 2

            val DAE = atan(CR / AR)
            val DAQ = PI.toFloat() / 2 - DAE
            val DAM = DAE / 2
            val AD = roundRadius / tan(DAM)
            val DQ = AD * sin(DAQ)
            val AQ = AD * cos(DAQ)

            //move to point D
            moveTo(AQ, DQ)

            val GCN = (PI.toFloat() - 2 * DAE) / 2
            val CG = roundRadius / tan(GCN)
            val GT = CG * sin(GCN)
            val CT = CG * cos(GCN)

            // line to point G
            lineTo(CR - CT, AR - GT)

            val CN = roundRadius / sin(GCN)
            val CNG = PI.toFloat() / 2 - GCN
            // right arc
            arcToRad(Rect(Offset(CR - CN, AR), roundRadius), -CNG, 2 * CNG, false)

            val AB = size.height

            // line to point K
            lineTo(AQ, AB - DQ)

            val OBV = DAM + DAQ
            val BO = roundRadius / sin(DAM)
            val BV = BO * cos(OBV)
            val OV = BO * sin(OBV)

            val BOV = PI.toFloat() - OBV
            val BOK = PI.toFloat() - DAM
            val KOV = BOK - BOV
            val KOU = PI.toFloat() / 2 - KOV
            val JOK = PI.toFloat() - DAE

            // bottom left arc
            arcToRad(Rect(Offset(BV, AB - OV), roundRadius), KOU, JOK, false)

            // line to point E
            lineTo(0f, AD)

            // top left arc
            arcToRad(Rect(Offset(BV, OV), roundRadius), PI.toFloat(), JOK, false)
        }
    )
}
