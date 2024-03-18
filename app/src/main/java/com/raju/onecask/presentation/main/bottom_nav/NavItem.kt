package com.raju.onecask.presentation.main.bottom_nav

import com.raju.onecask.R


sealed class NavItem {
    object Scan :
        Item(path = NavPath.SCAN.toString(), title = NavTitle.SCAN, icon = R.drawable.ic_scan)

    object Collection :
        Item(
            path = NavPath.COLLECTION.toString(),
            title = NavTitle.COLLECTION,
            icon = R.drawable.ic_collection
        )

    object Shop :
        Item(path = NavPath.SHOP.toString(), title = NavTitle.SHOP, icon = R.drawable.ic_shop)

    object Setting :
        Item(
            path = NavPath.SETTING.toString(),
            title = NavTitle.SETTING,
            icon = R.drawable.ic_settings
        )
}