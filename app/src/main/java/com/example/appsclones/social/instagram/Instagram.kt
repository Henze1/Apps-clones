package com.example.appsclones.social.instagram

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.example.appsclones.MainActivity.Companion.instagramSans
import com.example.appsclones.R
import com.example.appsclones.social.instagram.User.Companion.users

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Instagram(
    modifier: Modifier
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold(
        modifier = modifier
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            Column {
                TopAppBar(
                    scrollBehavior = scrollBehavior,
                    navigationIcon = {
                        Row(
                            modifier = Modifier
                                .padding(start = 16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            AsyncImage(
                                modifier = Modifier
                                    .size(140.dp),
                                model = R.drawable.instagram,
                                contentDescription = null
                            )

                            IconButton(
                                onClick = {

                                }
                            ) {
                                Icon(
                                    imageVector = Icons.Default.KeyboardArrowDown,
                                    tint = Color.White,
                                    contentDescription = null
                                )
                            }
                        }
                    },

                    actions = {
                        IconButton(
                            onClick = {

                            }
                        ) {
                            Icon(
                                modifier = Modifier
                                    .size(28.dp),
                                painter = painterResource(id = R.drawable.favorite),
                                tint = Color.White,
                                contentDescription = null
                            )
                        }

                        IconButton(
                            onClick = {

                            }
                        ) {
                            Icon(
                                modifier = Modifier
                                    .size(28.dp),
                                painter = painterResource(id = R.drawable.direct),
                                tint = Color.White,
                                contentDescription = null
                            )
                        }
                    },
                    title = {}
                )

                HorizontalDivider(
                    thickness = 0.2.dp,
                    color = Color.White
                )
            }

        },

        bottomBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(44.dp)
            ) {
                HorizontalDivider(
                    thickness = 0.2.dp,
                    color = Color.White
                )

                BottomAppBar(
                    modifier = Modifier.fillMaxWidth(),
                    containerColor = Color(0xFF141414),

                    ) {
                    IconButton(
                        modifier = Modifier
                            .weight(1f),
                        onClick = {

                        }
                    ) {
                        Icon(
                            modifier = Modifier
                                .size(28.dp),
                            painter = painterResource(R.drawable.home),
                            tint = Color.White,
                            contentDescription = null
                        )
                    }

                    IconButton(
                        modifier = Modifier
                            .weight(1f),
                        onClick = {

                        }
                    ) {
                        Icon(
                            modifier = Modifier
                                .size(28.dp),
                            painter = painterResource(R.drawable.search),
                            tint = Color.White,
                            contentDescription = null
                        )
                    }

                    IconButton(
                        modifier = Modifier
                            .weight(1f),
                        onClick = {

                        }
                    ) {
                        Icon(
                            modifier = Modifier
                                .size(28.dp),
                            painter = painterResource(R.drawable.add),
                            tint = Color.White,
                            contentDescription = null
                        )
                    }

                    IconButton(
                        modifier = Modifier
                            .weight(1f),
                        onClick = {

                        }
                    ) {
                        Icon(
                            modifier = Modifier
                                .size(28.dp),
                            painter = painterResource(R.drawable.reels),
                            tint = Color.White,
                            contentDescription = null
                        )
                    }

                    IconButton(
                        modifier = Modifier
                            .weight(1f),
                        onClick = {

                        }
                    ) {
                        AsyncImage(
                            modifier = Modifier
                                .size(28.dp)
                                .clip(CircleShape),
                            model = R.drawable.mainuser,
                            contentDescription = null
                        )
                    }
                }
            }
        }
    ) { innerPadding ->
        PostsColumn(
            users = users,
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
fun PostsColumn(
    modifier: Modifier,
    users: List<User>
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
    ) {
        item {
            StoryRow(users)
        }

        items(
            count = users.size,
            key = { index ->
                users[index].id
            }
        ) {
            val user = remember { mutableStateOf(users[it]) }
            val post = remember { mutableStateOf(user.value.post) }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, end = 4.dp, top = 8.dp, bottom = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(30.dp)
                            .clip(CircleShape)
                    ) {
                        AsyncImage(
                            modifier = Modifier
                                .fillMaxSize(),
                            model = user.value.image,
                            contentDescription = null,
                            contentScale = ContentScale.Crop
                        )
                    }

                    Text(
                        modifier = Modifier
                            .padding(start = 8.dp)
                            .weight(1f),
                        text = user.value.username,
                        fontWeight = FontWeight.Normal,
                        fontSize = 14.sp,
                        color = Color.White
                    )

                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            imageVector = Icons.Default.MoreVert,
                            contentDescription = null
                        )
                    }
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    AsyncImage(
                        modifier = Modifier
                            .fillMaxSize(),
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(post.value.image)
                            .crossfade(true)
                            .build(),
                        contentDescription = null,
                        contentScale = ContentScale.Crop
                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(
                        modifier = Modifier
                            .size(28.dp),
                        onClick = {}
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.favorite),
                            contentDescription = null
                        )
                    }

                    Text(
                        modifier = Modifier
                            .padding(start = 4.dp, end = 8.dp),
                        text = if (post.value.likes > 999) post.value.likes.toString().dropLast(3) + "K" else post.value.likes.toString(),
                        fontFamily = instagramSans,
                        fontWeight = FontWeight.Normal,
                        fontSize = 14.sp
                    )

                    IconButton(
                        modifier = Modifier
                            .size(28.dp),
                        onClick = {}
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.comment),
                            contentDescription = null
                        )
                    }

                    Text(
                        modifier = Modifier
                            .padding(start = 4.dp, end = 8.dp),
                        text = if (post.value.comments > 999) post.value.comments.toString().dropLast(3) + "K" else post.value.comments.toString(),
                        fontFamily = instagramSans,
                        fontWeight = FontWeight.Normal,
                        fontSize = 14.sp
                    )

                    IconButton(
                        modifier = Modifier
                            .size(28.dp),
                        onClick = {}
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.send),
                            contentDescription = null
                        )
                    }

                    Text(
                        modifier = Modifier
                            .weight(1f)
                            .padding(start = 4.dp, end = 8.dp),
                        text = if (post.value.shares > 999) post.value.shares.toString().dropLast(3) + "K" else post.value.shares.toString(),
                        fontFamily = instagramSans,
                        fontWeight = FontWeight.Normal,
                        fontSize = 14.sp
                    )

                    IconButton(
                        modifier = Modifier
                            .size(28.dp),
                        onClick = {}
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.bookmark),
                            contentDescription = null
                        )
                    }
                }

                post.value.description?.let {
                    Row(
                        modifier = Modifier
                            .padding(start = 16.dp, end = 16.dp),
                    ) {
                        Text(
                            text = user.value.username,
                            fontFamily = instagramSans,
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp,
                            color = Color.White
                        )

                        Spacer(Modifier.width(4.dp))

                        Text(
                            text = post.value.description!!,
                            fontFamily = instagramSans,
                            fontWeight = FontWeight.Normal,
                            fontSize = 14.sp
                        )
                    }
                }

                Text(
                    modifier = Modifier
                        .padding(start = 16.dp, end = 16.dp),
                    text = "View all comments",
                    fontFamily = instagramSans,
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp,
                    color = Color.Gray
                )

                Row(
                    modifier = Modifier
                        .padding(start = 16.dp, end = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Box(
                        modifier = Modifier
                            .size(30.dp)
                            .clip(CircleShape)
                    ) {
                        AsyncImage(
                            modifier = Modifier
                                .fillMaxSize(),
                            model = R.drawable.mainuser,
                            contentDescription = null,
                            contentScale = ContentScale.Crop
                        )
                    }

                    Text(
                        modifier = Modifier
                            .padding(start = 8.dp),
                        text = "Add a comment...",
                        fontFamily = instagramSans,
                        fontWeight = FontWeight.Normal,
                        fontSize = 14.sp,
                        color = Color.Gray
                    )
                }

                Text(
                    modifier = Modifier
                        .padding(start = 16.dp, end = 16.dp),
                    text = post.value.publishedAt,
                    fontFamily = instagramSans,
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp,
                    color = Color.Gray
                )
            }
        }
    }
}

@Composable
fun StoryRow(
    users: List<User>
) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        horizontalArrangement = Arrangement.spacedBy((-12).dp)
    ) {
        item{
            Column(
                modifier = Modifier
                    .size(110.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .size(84.dp)
                ) {
                    AsyncImage(
                        modifier = Modifier
                            .size(84.dp)
                            .clip(CircleShape),
                        model = R.drawable.mainuser,
                        contentDescription = null
                    )

                    IconButton(
                        modifier = Modifier
                            .border(
                                shape = CircleShape,
                                width = 1.dp,
                                color = Color.Black
                            )
                            .size(24.dp)
                            .align(Alignment.BottomEnd),
                        onClick = {},
                        colors = IconButtonDefaults.iconButtonColors(
                            containerColor = Color(0xFF0CAFFF),
                            contentColor = Color.White
                        )
                    ) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = null
                        )
                    }
                }

                Text(
                    modifier = Modifier
                        .padding(top = 4.dp),
                    text = "Your Story",
                    fontFamily = instagramSans,
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp,
                    color = Color.Gray
                )
            }
        }

        items(
            count = users.size,
            key = { index ->
                users[index].id
            }
        ) {
            Column(
                modifier = Modifier
                    .size(110.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .border(
                            shape = CircleShape,
                            width = 2.dp,
                            brush = Brush.linearGradient(
                                listOf(
                                    Color(0xFFFFD600),
                                    Color(0xFFFF7A00),
                                    Color(0xFFFF0069),
                                    Color(0xFFD300C5),
                                    Color(0xFF7638FA),
                                )
                            )
                        )
                        .size(84.dp)
                ) {
                    AsyncImage(
                        modifier = Modifier
                            .size(76.dp)
                            .clip(CircleShape)
                            .align(Alignment.Center),
                        model = users[it].image,
                        contentDescription = null,
                        contentScale = ContentScale.Crop
                    )
                }

                Text(
                    modifier = Modifier
                        .padding(top = 4.dp),
                    text = users[it].username,
                    fontFamily = instagramSans,
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp,
                    color = Color.Gray
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun InstagramPreview() {
    Instagram(
        modifier = Modifier
    )
}