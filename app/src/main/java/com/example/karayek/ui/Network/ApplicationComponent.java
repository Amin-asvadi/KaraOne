package com.example.karayek.ui.Network;


import com.example.karayek.ui.home.HomeFragment;

import dagger.Component;


@RetrofitScope
@Component(dependencies = NetComponent.class, modules = ApplicationModule.class)

public interface ApplicationComponent {

    void inject_first_page(HomeFragment homeFragment);
/*    void inject_singel_page(ProductItemActivity productItemActivity);*/
}