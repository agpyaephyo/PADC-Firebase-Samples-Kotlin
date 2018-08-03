package com.padcmyanmar.firebase.kotlin.data.models

import android.content.Context
import com.google.firebase.database.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.padcmyanmar.firebase.kotlin.data.vo.NewsFeedVO
import com.padcmyanmar.firebase.kotlin.events.FirebaseEvents
import org.greenrobot.eventbus.EventBus
import org.json.JSONException
import java.io.IOException
import java.util.*

class NewsFeedModel private constructor() {

    private val mDatabaseReference: DatabaseReference = FirebaseDatabase.getInstance().reference
    private var mNewsFeedDR: DatabaseReference? = null

    fun getSampleNewsFeed(context: Context): List<NewsFeedVO> {
        try {
            val newsFeed = loadDummyData(context, OFFLINE_NEWSFEED)
            val listType = object : TypeToken<List<NewsFeedVO>>() {

            }.type
            return Gson().fromJson(newsFeed, listType)
        } catch (e: IOException) {
            e.printStackTrace()
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return ArrayList<NewsFeedVO>()
    }

    fun loadNewsFeed() {
        mNewsFeedDR = mDatabaseReference.child(MM_NEWS_FEED)
        mNewsFeedDR!!.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val newsFeedList = ArrayList<NewsFeedVO>()
                for (snapshot in dataSnapshot.children) {
                    val newsFeed = snapshot.getValue<NewsFeedVO>(NewsFeedVO::class.java)
                    if (newsFeed != null) {
                        newsFeedList.add(newsFeed)
                    }
                }
                val event = FirebaseEvents.NewsFeedLoadedEvent(newsFeedList)
                EventBus.getDefault().post(event)
            }

            override fun onCancelled(databaseError: DatabaseError) {

            }
        })
    }

    /**
     * Read text from assets folder.
     *
     * @param fileName
     * @return
     * @throws IOException
     */
    @Throws(IOException::class)
    private fun readJsonFile(context: Context, fileName: String): ByteArray {
        val inStream = context.assets.open(fileName)
        val size = inStream.available()
        val buffer = ByteArray(size)
        inStream.read(buffer)
        inStream.close()
        return buffer
    }

    /**
     * @param fileName - name of Json File.
     * @return JSONObject from loaded file.
     * @throws IOException
     * @throws JSONException
     */
    @Throws(IOException::class, JSONException::class)
    private fun loadDummyData(context: Context, fileName: String): String {
        val buffer = readJsonFile(context, "$PATH_SAMPLE_DATA/$fileName")
        return String(buffer)
    }

    companion object {

        private const val PATH_SAMPLE_DATA = "sample_data"
        private const val OFFLINE_NEWSFEED = "news_feed.json"

        private const val MM_NEWS_FEED = "mmNewsFeed"

        private var objInstance: NewsFeedModel? = null

        val instance: NewsFeedModel
            get() {
                if (objInstance == null) {
                    objInstance = NewsFeedModel()
                }
                return objInstance!!
            }
    }
}