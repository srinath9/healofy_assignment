package com.hyprful.myapplication

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.NestedScrollView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() , PostClickListner{


  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    rvComments.adapter = CommentAdapter(this, fetchCommentData())
    rvPosts.adapter = PostAdapter(this, fetchPostData(), this)


  }

  fun fetchCommentData(): ArrayList<Comment> {
    var data : ArrayList<Comment> = ArrayList();
    data.add(Comment(1, "sometitle 1", "somedata", "https://cdn1.matadornetwork.com/blogs/1/2019/09/Taj-Mahal.jpg"))
    data.add(Comment(2, "sometitle 12", "somedata", "https://cdn1.matadornetwork.com/blogs/1/2019/09/Taj-Mahal.jpg"))
    data.add(Comment(3, "sometitle 2", "somedata", "https://cdn1.matadornetwork.com/blogs/1/2019/09/Taj-Mahal.jpg"))
    data.add(Comment(4, "sometitle 3", "somedata", "https://cdn1.matadornetwork.com/blogs/1/2019/09/Taj-Mahal.jpg"))
    data.add(Comment(5, "sometitle 4", "somedata", "https://cdn1.matadornetwork.com/blogs/1/2019/09/Taj-Mahal.jpg"))
    data.add(Comment(6, "sometitle 5", "somedata", "https://cdn1.matadornetwork.com/blogs/1/2019/09/Taj-Mahal.jpg"))
    data.add(Comment(7, "sometitle 6", "somedata", "https://cdn1.matadornetwork.com/blogs/1/2019/09/Taj-Mahal.jpg"))
    data.add(Comment(8, "sometitle 7", "somedata", "https://cdn1.matadornetwork.com/blogs/1/2019/09/Taj-Mahal.jpg"))

    return data
  }

  fun fetchPostData(): ArrayList<Post> {

    var data : ArrayList<Post> = ArrayList();
    data.add(Post(1, "somepost 1", "somedata", "https://cdn1.matadornetwork.com/blogs/1/2019/09/Taj-Mahal.jpg"))
    data.add(Post(2, "somepost 12", "somedata", "https://cdn1.matadornetwork.com/blogs/1/2019/09/Taj-Mahal.jpg"))
    data.add(Post(3, "somepost 2", "somedata", "https://cdn1.matadornetwork.com/blogs/1/2019/09/Taj-Mahal.jpg"))
    data.add(Post(4, "somepost 3", "somedata", "https://cdn1.matadornetwork.com/blogs/1/2019/09/Taj-Mahal.jpg"))
    data.add(Post(5, "somepost 4", "somedata", "https://cdn1.matadornetwork.com/blogs/1/2019/09/Taj-Mahal.jpg"))
    data.add(Post(6, "somepost 5", "somedata", "https://cdn1.matadornetwork.com/blogs/1/2019/09/Taj-Mahal.jpg"))
    data.add(Post(7, "somepost 6", "somedata", "https://cdn1.matadornetwork.com/blogs/1/2019/09/Taj-Mahal.jpg"))
    data.add(Post(8, "somepost 7", "somedata", "https://cdn1.matadornetwork.com/blogs/1/2019/09/Taj-Mahal.jpg"))

    return data
  }

  override fun postClicked() {
    motionLayout.transitionToEnd();

  }
}