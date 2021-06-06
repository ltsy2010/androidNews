package com.laioffer.tinnews.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.laioffer.tinnews.model.Article;
import com.laioffer.tinnews.model.NewsResponse;
import com.laioffer.tinnews.repository.NewsRepository;


//extends viewmodel
public class HomeViewModel extends ViewModel {

    private final NewsRepository repository;
    private final MutableLiveData<String> countryInput = new MutableLiveData<>();

    public HomeViewModel(NewsRepository newsRepository) {
        this.repository = newsRepository;
    }

    //input
    public void setCountryInput(String country) {
        countryInput.setValue(country); //observe news response
    }

    //output
    public LiveData<NewsResponse> getTopHeadlines() {
        return Transformations.switchMap(countryInput, repository::getTopHeadlines);
    } //pipe, put countryInput to getTopHeadlines, you will get livadata.
    //if there is subscribe, it will send data out.

    public void setFavoriteArticleInput(Article article) {
        repository.favoriteArticle(article);
    }

}
