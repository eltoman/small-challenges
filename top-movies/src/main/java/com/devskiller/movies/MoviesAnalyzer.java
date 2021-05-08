package com.devskiller.movies;

import java.util.*;
import java.util.stream.Collectors;

public class MoviesAnalyzer {

    public MoviesAnalyzer(List<Movie> movies, List<User> users) {
        this.movies = movies;
        this.users = users;
    }

    private final List<Movie> movies;
    private final List<User> users;

    public List<String> topFavouriteMoviesAmongFriends(int userId) {
        Map<String, Integer> friendsFavoriteMovies = new HashMap<>();

        List<User> friends = getUserFriends(userId);

        for (User friend: friends) {
            List<Movie> friendMovies = getUserMovies(friend.getUserId());
            mapFrequencyFriendsFavoriteMovies(friendsFavoriteMovies, friendMovies);
        }

        return getTopThreeMoviesByQuantityAndAlphabetically(friendsFavoriteMovies);
    }

    private List<String> getTopThreeMoviesByQuantityAndAlphabetically(Map<String, Integer> friendsFavoriteMovies) {
        List<String> topThree = new ArrayList<>();
        friendsFavoriteMovies.entrySet()
            .stream().sorted(Map.Entry.<String,Integer>comparingByValue(Comparator.reverseOrder())
            .thenComparing(Map.Entry::getKey))
            .forEach(entry -> {
                if(topThree.size() < 3) {
                    topThree.add(entry.getKey());
                }
        });
        return topThree;
    }

    private void mapFrequencyFriendsFavoriteMovies(Map<String, Integer> friendsFavoriteMovies, List<Movie> friendMovies) {
        for (Movie movie: friendMovies) {
            Integer current = friendsFavoriteMovies.get(movie.getTitle());
            int sum;
            sum = current == null ? 1 : current+1;
            friendsFavoriteMovies.put(movie.getTitle(), sum);
        }
    }

    private List<Movie> getUserMovies(int userId) {
        return movies.stream()
                .filter(m -> m.getFavorites().contains(userId))
                .collect(Collectors.toList());
    }

    private List<User> getUserFriends(int userId) {
        return users.stream()
                .filter(u -> u.getFriends().contains(userId))
                .collect(Collectors.toList());
    }
}
