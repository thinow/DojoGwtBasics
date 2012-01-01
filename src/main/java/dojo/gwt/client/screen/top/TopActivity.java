package dojo.gwt.client.screen.top;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;

import dojo.gwt.client.event.async.finished.AsyncFinishedEvent;
import dojo.gwt.client.event.async.started.AsyncStartedEvent;
import dojo.gwt.client.place.TopPlace;
import dojo.gwt.client.screen.top.TopView.Presenter;
import dojo.gwt.shared.rpc.object.MovieReference;
import dojo.gwt.shared.rpc.service.MovieServiceAsync;

public class TopActivity extends AbstractActivity implements Presenter {

	private TopPlace place;

	@Inject
	private TopView view;

	@Inject
	private MovieServiceAsync movieService;

	private EventBus eventBus;

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		this.eventBus = eventBus;

		panel.setWidget(view);
		view.setPresenter(this);

		view.clearList();
		startDataRetreiving();
	}

	private void startDataRetreiving() {
		eventBus.fireEvent(new AsyncStartedEvent());

		Integer count = place.getCount();
		movieService.getTopMovies(count, new AsyncCallback<MovieReference[]>() {

			@Override
			public void onSuccess(MovieReference[] result) {
				displayMovies(result);
				eventBus.fireEvent(new AsyncFinishedEvent());
			}

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Erreur lors de la récupération des films");
				eventBus.fireEvent(new AsyncFinishedEvent());
			}
		});
	}

	private void displayMovies(MovieReference[] movies) {
		for (MovieReference movie : movies) {
			view.addMovie(movie.getLabel(), goTo(movie));
		}
	}

	private ClickHandler goTo(MovieReference movie) {
		return new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Window.alert("Oops ! Cette page n'est pas encore disponible !");
			}
		};
	}

	public void setPlace(TopPlace place) {
		this.place = place;
	}

}
