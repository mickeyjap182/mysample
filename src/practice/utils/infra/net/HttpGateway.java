package practice.utils.infra.net;

public class HttpGateway {
//    public static void main(String[] args) throws KeyStoreException, UnrecoverableKeyException, NoSuchAlgorithmException, KeyManagementException, IOException, CertificateException {
//        // 在 192.168.0.12 上执行
//        // ssh root@192.168.0.12 -C -f -N -g -D 9999
//        Proxy proxy = new Proxy(Proxy.Type.SOCKS, new InetSocketAddress("192.168.0.12", 9999));
//
//        HttpHost proxy1 = HttpHost.create("socks://192.168.0.12:9999");
//
//        PlainConnectionSocketFactoryEx httpConnFac = new PlainConnectionSocketFactoryEx();
//        httpConnFac.setProxy(proxy);
////
////        KeyStore wxKeyStore = KeyStore.getInstance("PKCS12");
////        wxKeyStore.load(new FileInputStream("xxx.p12"), "ks-pass".toCharArray());
//        SSLContext sslcontext = SSLContexts.custom()
////                .loadKeyMaterial(wxKeyStore, "privateKeyPass".toCharArray())
//                .build();
//        SSLConnectionSocketFactoryEx httpsConnFac = new SSLConnectionSocketFactoryEx(
//                sslcontext,
//                new String[]{"TLSv1"},
//                null,
//                new DefaultHostnameVerifier());
//        httpsConnFac.setProxy(proxy);
//
//        Registry<ConnectionSocketFactory> reg = RegistryBuilder.<ConnectionSocketFactory>create()
//                .register("http", httpConnFac)
//                .register("https", httpsConnFac)
//                .build();
//
//        BasicHttpClientConnectionManager connMgr = new BasicHttpClientConnectionManager(reg);
//        CloseableHttpClient httpCient = HttpClients.custom()
//                .setConnectionManager(connMgr)
//                .build();
//
//        HttpComponentsClientHttpRequestFactory reqFac = new HttpComponentsClientHttpRequestFactory(httpCient);
//        RestTemplate restTemplate = new RestTemplate();
//        restTemplate.setRequestFactory(reqFac);
//
//
//        String url = "http://example.com";
//        String respStr = restTemplate.getForObject(url, String.class);
//        System.out.println(respStr);
////ss0.bdstatic.com
//    }
//    public static class PlainConnectionSocketFactoryEx extends PlainConnectionSocketFactory {
//        private Proxy proxy;
//
//        public PlainConnectionSocketFactoryEx() {
//            super();
//        }
//
//        @Override
//        public Socket createSocket(final HttpContext context) throws IOException {
//            if (proxy != null) {
//                System.out.println("---------------");
//                return new Socket(proxy);
//            }
//            return super.createSocket(context);
//        }
//
//        public void setProxy(Proxy proxy) {
//            this.proxy = proxy;
//        }
//    }
//
//    public static class SSLConnectionSocketFactoryEx extends SSLConnectionSocketFactory {
//
//        private Proxy proxy;
//
//        public SSLConnectionSocketFactoryEx(SSLContext sslContext) {
//            super(sslContext);
//        }
//
//        public SSLConnectionSocketFactoryEx(SSLContext sslContext, X509HostnameVerifier hostnameVerifier) {
//            super(sslContext, hostnameVerifier);
//        }
//
//        public SSLConnectionSocketFactoryEx(SSLContext sslContext, String[] supportedProtocols, String[] supportedCipherSuites, X509HostnameVerifier hostnameVerifier) {
//            super(sslContext, supportedProtocols, supportedCipherSuites, hostnameVerifier);
//        }
//
//        public SSLConnectionSocketFactoryEx(SSLSocketFactory socketfactory, X509HostnameVerifier hostnameVerifier) {
//            super(socketfactory, hostnameVerifier);
//        }
//
//        public SSLConnectionSocketFactoryEx(SSLSocketFactory socketfactory, String[] supportedProtocols, String[] supportedCipherSuites, X509HostnameVerifier hostnameVerifier) {
//            super(socketfactory, supportedProtocols, supportedCipherSuites, hostnameVerifier);
//        }
//
//        public SSLConnectionSocketFactoryEx(SSLContext sslContext, HostnameVerifier hostnameVerifier) {
//            super(sslContext, hostnameVerifier);
//        }
//
//        public SSLConnectionSocketFactoryEx(SSLContext sslContext, String[] supportedProtocols, String[] supportedCipherSuites, HostnameVerifier hostnameVerifier) {
//            super(sslContext, supportedProtocols, supportedCipherSuites, hostnameVerifier);
//        }
//
//        public SSLConnectionSocketFactoryEx(SSLSocketFactory socketfactory, HostnameVerifier hostnameVerifier) {
//            super(socketfactory, hostnameVerifier);
//        }
//
//        public SSLConnectionSocketFactoryEx(SSLSocketFactory socketfactory, String[] supportedProtocols, String[] supportedCipherSuites, HostnameVerifier hostnameVerifier) {
//            super(socketfactory, supportedProtocols, supportedCipherSuites, hostnameVerifier);
//        }
//
//        @Override
//        public Socket createSocket(final HttpContext context) throws IOException {
//            if (proxy != null) {
//                System.out.println("================");
//                return new Socket(proxy);
//            }
//            return super.createSocket(context);
//        }
//
//        public void setProxy(Proxy proxy) {
//            this.proxy = proxy;
//        }
//
//    }
}
