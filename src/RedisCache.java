import redis.clients.jedis.Jedis;

public class RedisCache {
    String host;
    int port;
    String password;
    Jedis jedis;
    public RedisCache(){
      jedis = new Jedis(host,port);
      jedis.auth(password);
    }
    public void addCityDetails(String CityName, String CityDetails){
        jedis.set(CityName,CityDetails);
    }
    public String getCityDetails(String CityName){
        return jedis.get(CityName);
    }
}
