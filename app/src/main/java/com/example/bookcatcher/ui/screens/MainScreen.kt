package com.example.bookcatcher.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import co.yml.charts.axis.AxisConfig
import co.yml.charts.axis.AxisData
import co.yml.charts.axis.DataCategoryOptions
import co.yml.charts.common.model.PlotType
import co.yml.charts.common.model.Point
import co.yml.charts.common.utils.DataUtils
import co.yml.charts.common.utils.DataUtils.getColorPaletteList
import co.yml.charts.ui.barchart.GroupBarChart
import co.yml.charts.ui.barchart.models.BarPlotData
import co.yml.charts.ui.barchart.models.GroupBarChartData
import co.yml.charts.ui.linechart.LineChart
import co.yml.charts.ui.linechart.model.GridLines
import co.yml.charts.ui.linechart.model.IntersectionPoint
import co.yml.charts.ui.linechart.model.Line
import co.yml.charts.ui.linechart.model.LineChartData
import co.yml.charts.ui.linechart.model.LinePlotData
import co.yml.charts.ui.linechart.model.LineStyle
import co.yml.charts.ui.linechart.model.LineType
import co.yml.charts.ui.linechart.model.SelectionHighlightPoint
import co.yml.charts.ui.linechart.model.SelectionHighlightPopUp
import co.yml.charts.ui.linechart.model.ShadowUnderLine
import co.yml.charts.ui.piechart.charts.DonutPieChart
import co.yml.charts.ui.piechart.charts.PieChart
import co.yml.charts.ui.piechart.models.PieChartConfig
import co.yml.charts.ui.piechart.models.PieChartData
import com.example.bookcatcher.R
import com.example.bookcatcher.viewModel.MainViewModel
import com.example.compose.BookCatcherTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val uiState = MainViewModel()
    Scaffold(topBar = {
        BookTopAppBar(
            title = stringResource(R.string.app_name),
        )
    }
    ) { innerPadding ->
        Column(Modifier.verticalScroll(rememberScrollState())) {
            Card(
                modifier = Modifier.padding(
                    top = innerPadding.calculateTopPadding(),
                    end = dimensionResource(R.dimen.padding_small),
                    start = dimensionResource(R.dimen.padding_small),
                    bottom = 0.dp
                )
            ) {
                Column() {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(0.dp)
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(
                                text = "0",
                                style = MaterialTheme.typography.displaySmall
                            )
                            Text(
                                text = stringResource(R.string.yesterday),
                                style = MaterialTheme.typography.labelMedium
                                //modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
                            )
                        }
                        DonutChartModule()
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(
                                text = uiState.mainUiState.number.toString(),
                                style = MaterialTheme.typography.displaySmall
                            )
                            Text(
                                text = stringResource(R.string.goal),
                                style = MaterialTheme.typography.labelMedium
                                //modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
                            )
                        }
                    }
                    Row(
                        modifier = Modifier.padding(
                            top = 0.dp,
                            start = dimensionResource(R.dimen.padding_small),
                            bottom = dimensionResource(R.dimen.padding_small),
                            end = dimensionResource(R.dimen.padding_small)
                        )
                    ) {
                        Button(
                            onClick = { /*TODO*/ },
                            modifier = Modifier
                                .padding(end = dimensionResource(R.dimen.padding_small))
                                .fillMaxWidth(0.5f)
                        ) {
                            Text(text = stringResource(R.string.add_sheet))
                        }
                        Button(
                            onClick = { uiState.reduceNum() },
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Text(text = stringResource(R.string.change_goal))
                        }
                    }
                }
            }

            Card(
                modifier = Modifier
                    .padding(dimensionResource(R.dimen.padding_small))
                    .fillMaxHeight(0.5f)
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = stringResource(R.string.weekly_progress),
                        style = MaterialTheme.typography.headlineSmall,
                        modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
                    )
                    LineChartModule()
                }
            }

            Card(modifier = Modifier
                .padding(
                    top = 0.dp,
                    end = dimensionResource(R.dimen.padding_small),
                    start = dimensionResource(R.dimen.padding_small),
                    bottom = dimensionResource(R.dimen.padding_small)
                )
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = stringResource(R.string.weekly_progress),
                        style = MaterialTheme.typography.headlineSmall,
                        modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
                    )
                    LineChartModule()
                }
            }
        }
    }

}

@Composable
fun DonutChartModule() {
    val donutChartData = PieChartData(
        slices = listOf(
            PieChartData.Slice("HP", 10f, MaterialTheme.colorScheme.tertiary),
            PieChartData.Slice("Dell", 20f, MaterialTheme.colorScheme.outline),
            PieChartData.Slice("Lenovo", 30f, MaterialTheme.colorScheme.onBackground),
            PieChartData.Slice("Asus", 20f, MaterialTheme.colorScheme.inversePrimary),
            PieChartData.Slice("Asus", 50f, MaterialTheme.colorScheme.primary)
        ),
        plotType = PlotType.Donut
    )

    val donutChartConfig = PieChartConfig(

        backgroundColor = MaterialTheme.colorScheme.surfaceVariant,
        showSliceLabels = true,
        sliceLabelTextSize = 15.sp,
        isSumVisible = true,
        isClickOnSliceEnabled = true,
        //sumUnit = stringResource(R.string.today),
        labelColor = MaterialTheme.colorScheme.onSurface,
        labelFontSize = 25.sp,
        labelVisible = true,
        activeSliceAlpha = 0.5f,
        chartPadding = 25,
        strokeWidth = 50f
    )

    DonutPieChart(
        modifier = Modifier
            .size(150.dp),
        donutChartData,
        donutChartConfig
    )

}

@Composable
fun LineChartModule() {
    val steps = 5
    val pointsData = listOf(
        Point(0f, 40f),
        Point(1f, 90f),
        Point(2f, 0f),
        Point(3f, 60f),
        Point(4f, 80f),
        Point(5f, 50f),
        Point(6f, 30f),
    )

    val pointsData2 = listOf(
        Point(0f, 20f),
        Point(1f, 33f),
        Point(2f, 60f),
        Point(3f, 60f),
        Point(4f, 50f),
        Point(5f, 0f),
        Point(6f, 35f),
    )

    val xAxisData = AxisData.Builder()
        .axisStepSize(45.dp)
        .backgroundColor(MaterialTheme.colorScheme.surfaceVariant)
        .steps(pointsData.size - 1)
        .labelData { i -> i.toString() }
        .labelAndAxisLinePadding(15.dp)
        .axisLineColor(MaterialTheme.colorScheme.onSurface)
        .axisLabelColor(MaterialTheme.colorScheme.onSurface)
        .build()

    val yAxisData = AxisData.Builder()
        .steps(steps)
        .backgroundColor(MaterialTheme.colorScheme.surfaceVariant)
        .labelAndAxisLinePadding(25.dp)
        .labelData { i ->
            val yScale = 100 / steps
            (i * yScale).toString()

        }
        .axisLineColor(MaterialTheme.colorScheme.onSurface)
        .axisLabelColor(MaterialTheme.colorScheme.onSurface)
        .build()

    val lineChartData = LineChartData(
        linePlotData = LinePlotData(
            lines = listOf(
                Line(
                    dataPoints = pointsData,
                    LineStyle(
                        color = MaterialTheme.colorScheme.primary,
                        lineType = LineType.SmoothCurve(),
                    ),
                    IntersectionPoint(color = MaterialTheme.colorScheme.primary),
                    SelectionHighlightPoint(color = MaterialTheme.colorScheme.onSurface),
                    ShadowUnderLine(
                        alpha = 0.5f,
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                MaterialTheme.colorScheme.inversePrimary,
                                Color.Transparent
                            )
                        )
                    ),
                    SelectionHighlightPopUp()
                ),
                Line(dataPoints = pointsData2,
                    LineStyle(
                        color = MaterialTheme.colorScheme.tertiary,
                        lineType = LineType.SmoothCurve(),
                    ),
                    IntersectionPoint(color = MaterialTheme.colorScheme.tertiary),
                    SelectionHighlightPoint(color = MaterialTheme.colorScheme.onSurface),
                    ShadowUnderLine(
                        alpha = 0.5f,
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                MaterialTheme.colorScheme.onTertiary,
                                Color.Transparent
                            )
                        )
                    ),
                    SelectionHighlightPopUp())
            )
        ),
        isZoomAllowed = true,
        backgroundColor = MaterialTheme.colorScheme.outlineVariant,
        xAxisData = xAxisData,
        yAxisData = yAxisData,
        gridLines = GridLines(color = MaterialTheme.colorScheme.onSurface)
    )

    Column(modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))) {
        LineChart(
            lineChartData = lineChartData,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )
    }
}

@Composable
fun GroupBarChartModule(){
    val groupBarData = BarPlotData(
        groupBarList = DataUtils.getGroupBarChartData(
            3,
            500,
            5
        ),
        barColorPaletteList = getColorPaletteList(5)
    )

    val xAxisData = AxisData.Builder()
        .axisStepSize(30.dp)
        .labelData { index -> "$index" }
        .build()

    val yAxisData = AxisData.Builder()
        .steps(10)
        .labelAndAxisLinePadding(20.dp)
        .axisOffset(20.dp)
        .labelData { index -> (index * (500 / 10)).toString() }
        .build()

    val groupBarChartData = GroupBarChartData(
        barPlotData = groupBarData,
        xAxisData = xAxisData,
        yAxisData = yAxisData
    )

    GroupBarChart(modifier = Modifier.height(300.dp), groupBarChartData = groupBarChartData)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookTopAppBar(title: String, modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(title = { Text(title) })
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun PreviewMainScreen() {
    BookCatcherTheme(useDarkTheme = true) {
        MainScreen()
    }
}