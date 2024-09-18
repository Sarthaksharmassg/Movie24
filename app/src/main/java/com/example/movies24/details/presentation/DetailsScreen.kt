package com.example.movies24.details.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BrokenImage
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.drawable.toBitmap
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavBackStackEntry
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.example.movies24.R
import com.example.movies24.movieList.data.remote.MovieApi
import com.example.movies24.movieList.util.RatingBar
import com.example.movies24.movieList.util.getAvgColor

@Composable
fun DetailsScreen(){

    val detailsViewModel= hiltViewModel<DetailsVIewModel>()
    val detailssState=detailsViewModel.detailsState.collectAsState().value
    val backDropImageState= rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .data(MovieApi.IMAGE_BASE_URL+ detailssState.movie?.backdrop_path)
            .size(Size.ORIGINAL).build()
    ).state
    val posterDropImageState= rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .data(MovieApi.IMAGE_BASE_URL+ detailssState.movie?.poster_path)
            .size(Size.ORIGINAL).build()
    ).state //This is how we load img form coil

    Column (modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())){
        if(backDropImageState is AsyncImagePainter.State.Error){
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .background(MaterialTheme.colorScheme.primaryContainer),
                contentAlignment = Alignment.Center
            ){
                Icon(imageVector = Icons.Default.BrokenImage, contentDescription = detailssState.movie?.title,modifier=Modifier.size(70.dp))
            }
        }

        if(backDropImageState is AsyncImagePainter.State.Success){
           //  dominantColor= getAvgColor(imageBitmap =backDropImageState.result.drawable.toBitmap().asImageBitmap())
            Image(modifier = Modifier
                .fillMaxWidth()
                .height(220.dp)
                .clip(RoundedCornerShape(22.dp)),
                painter = backDropImageState.painter,
                contentDescription =  detailssState.movie?.title,
                contentScale = ContentScale.Crop
            )
        }

        Spacer(modifier=Modifier.height(16.dp))
        Row(modifier= Modifier
            .fillMaxWidth()
            .padding(16.dp)){
            Box(modifier= Modifier
                .width(160.dp)
                .height(240.dp)) {
                if (posterDropImageState is AsyncImagePainter.State.Error) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(RoundedCornerShape(8.dp))
                            .background(MaterialTheme.colorScheme.primaryContainer),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.BrokenImage,
                            contentDescription = detailssState.movie?.title,
                            modifier = Modifier.size(70.dp)
                        )
                    }
                }
                if (posterDropImageState is AsyncImagePainter.State.Success) {
                    //  dominantColor= getAvgColor(imageBitmap =backDropImageState.result.drawable.toBitmap().asImageBitmap())
                    Image(
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(RoundedCornerShape(12.dp)),
                        painter = posterDropImageState.painter,
                        contentDescription = detailssState.movie?.title,
                        contentScale = ContentScale.Crop
                    )
                }
            }
                detailssState.movie?.let{
                    Column(modifier = Modifier.fillMaxWidth()){
                        Text(text = it.title,
                            fontSize=19.sp,
                            fontWeight = FontWeight.SemiBold,
                            modifier=Modifier.padding(16.dp))

                        Spacer(modifier=Modifier.height(16.dp))
                        Row(modifier= Modifier
                            .fillMaxSize()
                            .padding(start = 16.dp)){
                            RatingBar(
                                starsModifier = Modifier.size(18.dp),
                                rating=it.vote_average/2,
                            )
                            Text(modifier =Modifier.padding(start=4.dp) ,
                                text=it.vote_average.toString().take(3),
                                color= Color.Yellow,
                                fontSize=14.sp,
                                maxLines=1)
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(text = stringResource(R.string.language)+": " +it.original_language,
                            modifier=Modifier.padding(start=16.dp))


                        Spacer(modifier = Modifier.height(10.dp))

                        Text(text = stringResource(R.string.release_date) +it.release_date,
                            modifier=Modifier.padding(start=16.dp))

                        Spacer(modifier = Modifier.height(10.dp))

                        Text(text = "Popularity: " +it.popularity,
                            modifier=Modifier.padding(start=16.dp))


                    }
                }
        }
        Spacer(modifier = Modifier.height(32.dp))
        Text(text = "OverView",
            fontSize=19.sp,
            fontWeight = FontWeight.SemiBold,
            modifier=Modifier.padding(start=16.dp))

        Spacer(modifier = Modifier.height(8.dp))

        detailssState.movie?.let{
            Text(text =it.overview ,
                fontSize=16.sp,
                modifier=Modifier.padding(start=16.dp))
        }
        Spacer(modifier = Modifier.padding(32.dp))
    }
}