function map() {


    var map = L.map('map').setView([35.6792, 139.7406], 16);

// 背景の地図タイル表示（OpenStreetMap のテンプレート URL を参照）
    L.tileLayer('http://{s}.tile.osm.org/{z}/{x}/{y}.png', {
        attribution: '&copy; <a href="http://osm.org/copyright">OpenStreetMap</a> contributors'
    }).addTo(map);

// マーカーの表示
    L.marker([42.793532, 141.695993]).addTo(map)
        .bindPopup('<b>Esri Japan</b> is here!')
        .openPopup();

// ArcGIS 住所検索サービス
    var arcgisOnline = L.esri.Geocoding.arcgisOnlineProvider();

// 住所検索コンポーネント
    var searchControl = L.esri.Geocoding.geosearch({
        providers: [arcgisOnline]
    }).addTo(map);

// 検索結果を表示するための空のレイヤー（L.layerGroup）
    var results = L.layerGroup().addTo(map);

// 住所検索の結果取得イベント リスナー
    searchControl.on('results', function (data) {
        // 検索結果をクリア
        results.clearLayers();
        // 検索結果をマーカーとしてレイヤーに追加
        for (var i = data.results.length - 1; i >= 0; i--) {
            results.addLayer(L.marker(data.results[i].latlng));
        }
    });
}
