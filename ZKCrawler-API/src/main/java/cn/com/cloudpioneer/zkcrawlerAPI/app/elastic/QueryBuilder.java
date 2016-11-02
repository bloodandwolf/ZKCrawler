package cn.com.cloudpioneer.zkcrawlerAPI.app.elastic;

import cn.com.cloudpioneer.zkcrawlerAPI.model.elastic.CmsData;
import cn.com.cloudpioneer.zkcrawlerAPI.model.elastic.QueryEntity;
import org.elasticsearch.client.ResponseListener;
import org.elasticsearch.client.RestClient;

import java.util.List;

/**
 * Created by TianyuanPan on 11/1/16.
 */
public interface QueryBuilder {

    List<CmsData> performQuery(RestClient client, QueryEntity queryEntity);

    void performQueryAsync(RestClient client, ResponseListener responseListener, QueryEntity queryEntity);
}
