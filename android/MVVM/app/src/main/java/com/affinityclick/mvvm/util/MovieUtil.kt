package com.affinityclick.mvvm.util

object MovieUtil {
  /**
   *
   * @param imagePath A relative image path.
   * @return A String URL based on the relative image path
   */
  fun imagePathBuilder(imagePath: String) = "https://image.tmdb.org/t/p/w500$imagePath"

}