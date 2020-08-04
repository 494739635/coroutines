package com.sample.jetpack.retrofit.enity

/**
 * @author Shuxq
 * Date 2019/12/31.
 * description：
 */
class UserInfo {

    var nickName: String? = null
    var imageUrl: String? = null
    var gender: String? = null
    var birthday: String? = null
    var signature: String? = null
    var csUserId: String? = null
    var favoritePet: Int = 0
    var favoriteCount: Int = 0
    var favoriteUser: Int = 0
    var favoriteMe: Int = 0
    var collectionNum: Int = 0
    var familyNum: Int = 0
    var isFavorite: Boolean = false
    var isSubject: Boolean = false
    var subjectId: Long = 0
    var membersCount: Int = 0
    var tags: List<String>? = null
}
