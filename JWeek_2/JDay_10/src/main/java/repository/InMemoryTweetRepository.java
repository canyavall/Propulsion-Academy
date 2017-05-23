package repository;

import domain.Tweet;

public class InMemoryTweetRepository extends AbstractCrudRepository<Tweet, String> implements TweetRepository {
}