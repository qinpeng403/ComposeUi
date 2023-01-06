package com.iflytek.composedemo.ui.basicComponent

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import com.iflytek.composedemo.R

//直接显示
@Composable
fun TextSample() {
    Text(text = "Hello World")
}

//从资源文件读取
@Composable
fun TextSample2() {
    Text(text = stringResource(R.string.app_name))
}

//设置颜色
@Composable
fun TextSample3() {
    Text(text = stringResource(R.string.app_name), color = Color.Red)
}

@OptIn(ExperimentalUnitApi::class)
@Composable
fun TextSample4() {
    Text(text = "Hello World", fontSize = TextUnit(16f, TextUnitType.Sp))
}

@Composable
fun TextSample5() {
    Text(text = "Hello World", fontSize = 16.0.sp)
}

@Composable
fun TextSample6() {
    Text(text = "Hello World", fontSize = 16.em)
}

@Composable
fun TextSample7() {
    Text(text = "Hello World", fontStyle = FontStyle.Italic)
}

@Composable
fun TextSample8() {
    Text(text = "Hello World", fontWeight = FontWeight(1000))
}

@Composable
fun TextSample9() {
    val firstFontFamily = FontFamily(Font(R.font.hyzhengyuan55w, FontWeight.Bold))
    Text(text = "Hello World", fontFamily = firstFontFamily)
}

@Composable
fun TextSample10() {
    Text(text = "Hello World", letterSpacing = 10.sp)
}

@Composable
fun TextSample11() {
    Text(text = "Hello World", textDecoration = TextDecoration.Underline)
}

@Composable
fun TextSample12() {
    Text(
        text = "Hello World", textDecoration = TextDecoration.combine(
            listOf(
                TextDecoration.LineThrough, TextDecoration.Underline
            )
        )
    )
}

@Composable
fun TextSample13() {
    Text(text = "Hello World", modifier = Modifier.size(50.dp), textAlign = TextAlign.Start)
}

@Composable
fun TextSample14() {
    Text(text = "Hello World", lineHeight = 25.sp)
}

@Composable
fun TextSample15() {
    Text(
        text = "Hello World Hello World Hello World Hello World Hello World",
        overflow = TextOverflow.Ellipsis,
        maxLines = 1
    )
}

@Composable
fun TextSample16() {
    Text(
        text = "锄禾日当午，汗滴禾下土。谁知盘中餐，粒粒皆辛苦", modifier = Modifier.width(100.dp), style = TextStyle(
            background = Color.White,
            shadow = Shadow(color = Color.Red, offset = Offset(5f, 5f), blurRadius = 10f),
            textIndent = TextIndent(20.sp)
        )
    )
}

@Composable
fun TextSample17() {
    SelectionContainer() {
        Text(text = "Hello World")
    }
}

@Composable
fun TextSample18() {
    Text(
        buildAnnotatedString {
            withStyle(style = SpanStyle(Color.Red, background = Color.Blue)) {
                append("锄禾日当午，")
            }
            withStyle(style = SpanStyle(Color.Green)) {
                append("汗滴禾下土。")
            }
            withStyle(style = SpanStyle(Color.Blue)) {
                append("谁知盘中餐，")
            }
            withStyle(style = SpanStyle(Color.Yellow)) {
                append("粒粒皆辛苦")
            }
        }
    )
}

@Composable
fun TextSample19() {
    ClickableText(
        buildAnnotatedString {
            withStyle(style = SpanStyle(Color.Red)) {
                append("锄禾日当午，")
            }
            withStyle(style = SpanStyle(Color.Green)) {
                append("汗滴禾下土。")
            }
            withStyle(style = SpanStyle(Color.Blue)) {
                append("谁知盘中餐，")
            }
            withStyle(style = SpanStyle(Color.Yellow)) {
                append("粒粒皆辛苦")
            }
        }, onClick = { offset ->
            println("offset:$offset")
        }
    )
}

@Composable
fun TextSample20() {
    val annotatedString = buildAnnotatedString {
        append("点击登录代表您知悉和同意")

        //往字符串中添加一个注解，直到遇到 pop() 。tag 为注解标识，annotation 为传递内容
        pushStringAnnotation("protocol", annotation = "https://github.com/qinpeng403/ComposeUi/")
        withStyle(style = SpanStyle(Color.Blue)) {
            append("用户协议")
        }
        pop()

        append("和")

        pushStringAnnotation("privacy", annotation = "https://github.com/qinpeng403/ComposeUi/")
        withStyle(style = SpanStyle(Color.Blue)) {
            append("隐私政策")
        }
        pop()
    }

    ClickableText(
        annotatedString, onClick = { offset ->
            //从字符串中查找注解
            annotatedString.getStringAnnotations("protocol", start = offset, end = offset)
                .firstOrNull()?.let { annotation ->
                    println("点击了用户协议：${annotation.item}")
                }

            annotatedString.getStringAnnotations("privacy", start = offset, end = offset)
                .firstOrNull()?.let { annotation ->
                    println("点击了隐私政策：${annotation.item}")
                }
        }
    )
}

@Preview
@Composable
fun TextSamplePreview() {
    TextSample20()
}