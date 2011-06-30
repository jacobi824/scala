/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.jacobiz.hatenagraph

import java.io.IOException
import java.text.SimpleDateFormat
import java.util.Date
import org.apache.http.HttpException
import org.apache.http.client.methods.HttpPost
import org.apache.http.impl.client.DefaultHttpClient
import org.apache.http.params.BasicHttpParams

class HatenaGraph(username: String, password: String) {
  def post(graphName: String, date: Date, value: String) {
    HatenaGraph.post(username, password, graphName, date, value)
  }
}

object HatenaGraph {
  private val HatenaGraphApiBaseUrl = "http://graph.hatena.ne.jp/api/"
  private val DateFormat = new SimpleDateFormat("yyyy-MM-dd")
  def post(username: String, password: String, graphName: String, date: Date, value: String) {
    val client = new DefaultHttpClient()
    
    val params = new BasicHttpParams
    params.setParameter("graphname", graphName)
    if (date != null) {
      params.setParameter("date", DateFormat.format(new Date))
    }
    params.setParameter("value", value)
    
    val post = new HttpPost(HatenaGraphApiBaseUrl + "post")
    post.setHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
    post.addHeader("X-WSSE", "")
    post.setParams(params)
    
    val response = 
//      try {
        client.execute(post)
//      }
//      catch {
//        case e: HttpException => throw new HatenaException(e)
//        case e: IOException   => throw new HatenaException(e)
//      }
    val statusCode = response.getStatusLine
    println(statusCode)
  }
}
