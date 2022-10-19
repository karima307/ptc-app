package android.ptc.com.ptcflixing.view.components

import android.ptc.com.ptcflixing.model.objects.SearchResultModel
import android.ptc.com.ptcflixing.view.theme.Orange700
import android.ptc.com.ptcflixing.view.theme.Grey
import android.ptc.com.ptcflixing.view.theme.Shapes
import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.gowtham.ratingbar.RatingBar
import com.gowtham.ratingbar.RatingBarConfig
import com.gowtham.ratingbar.RatingBarStyle

@Composable
fun ResultItemList(result: SearchResultModel) {
    Card(
        elevation = 7.dp, shape = RoundedCornerShape(6.dp),
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(0.7f)
                .padding(8.dp)
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(result.image)
                    .crossfade(true)
                    .build(),
                contentDescription = "",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            )
            Text(
                text = result.brand ?: "",
                fontSize = 16.sp,
                modifier = Modifier
                    .padding(start = 8.dp)
                    .align(Alignment.CenterHorizontally),
                overflow = TextOverflow.Ellipsis,
                maxLines = 2
            )
            Text(
                text = result.name ?: "",
                fontSize = 16.sp,
                modifier = Modifier
                    .padding(start = 8.dp)
                    .align(Alignment.CenterHorizontally),
                overflow = TextOverflow.Ellipsis,
                maxLines = 2
            )
           Row() {
               Text(
                   text ="${ result.specialPrice ?: 0} $",
                   fontSize = 16.sp,
                   modifier = Modifier
                       .padding(start = 8.dp),
                   overflow = TextOverflow.Ellipsis,
                   maxLines = 2
               )
               Spacer(modifier = Modifier
                   .padding(start = 40.dp))
            Card(
                border = BorderStroke(2.dp,Orange700),
                        modifier = Modifier
                        .padding(2.dp)

                ,
            ) {

                    Text(
                        text ="-${ result.maxSavingPercentage ?: 0}%",
                        fontSize = 16.sp,
                        modifier = Modifier
                            .padding(start = 6.dp, end = 6.dp, top = 2.dp, bottom = 2.dp),
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1
                    )

            }
           }
            Text(
                text ="${ result.price ?: 0} $",
                fontSize = 16.sp,

                modifier = Modifier
                    .padding(start = 8.dp)
                    .align(Alignment.Start),
                overflow = TextOverflow.Ellipsis,
                maxLines = 2,
                style = TextStyle(textDecoration = TextDecoration.LineThrough, color = Grey)
            )
            RatingBar(

                value = (result.ratingAverage?:0).toFloat(),
                config = RatingBarConfig()
                    .style(RatingBarStyle.HighLighted).size(15.dp),
                onValueChange = {},
                onRatingChanged = {
                   Log.d("TAG", "onRatingChanged: $it")
                }
            )
        }
    }
}

@Preview
@Composable
fun ResultItemListPreview() {
    ResultItemList(result = SearchResultModel("SKUTEST", "3510", "Nokia", 10, 10))
}