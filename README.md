## 概要
WebfluxとSpring Data R2DBCによるサンプルプロジェクトです。  
その他、以下も実装されています。
+ Flywayによるマイグレーション
+ JUnit5 + mockito-kotlin + StepVerifierによるユニットテスト

## 使い方
build.gradle.ktsを指定してIntellij IDEAで開くとGradle Projectとして読み込まれます。

### DB起動
```
docker-compose up -d
```

MySQL 5.7が起動します。
ボリュームのマウントはしていないので、再起動したらデータも初期化される点に留意してください。

### アプリケーション起動
DBを起動した上で、下記コマンドを実行。
```
❯ ./gradlew bootRun

> Task :bootRun

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v2.4.2)

2021-02-13 19:36:34.801  INFO 59550 --- [           main] c.e.w.WebfluxR2dbcSampleApplicationKt    : Starting WebfluxR2dbcSampleApplicationKt using Java 11.0.7 on hisawashoutanoiMac.local with PID 59550 (/Users/hshota/webflux-r2dbc-sample/build/classes/kotlin/main started by hshota in /Users/hshota/webflux-r2dbc-sample)
2021-02-13 19:36:34.803  INFO 59550 --- [           main] c.e.w.WebfluxR2dbcSampleApplicationKt    : No active profile set, falling back to default profiles: default
2021-02-13 19:36:35.261  INFO 59550 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data R2DBC repositories in DEFAULT mode.
2021-02-13 19:36:35.309  INFO 59550 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 45 ms. Found 2 R2DBC repository interfaces.
2021-02-13 19:36:35.769  INFO 59550 --- [           main] o.f.c.internal.license.VersionPrinter    : Flyway Community Edition 7.1.1 by Redgate
2021-02-13 19:36:35.920  INFO 59550 --- [           main] o.f.c.i.database.base.DatabaseType       : Database: jdbc:mysql://localhost:33306/webflux_r2dbc_sample (MySQL 5.7)
2021-02-13 19:36:35.974  INFO 59550 --- [           main] o.f.core.internal.command.DbValidate     : Successfully validated 2 migrations (execution time 00:00.026s)
2021-02-13 19:36:35.994  INFO 59550 --- [           main] o.f.core.internal.command.DbMigrate      : Current version of schema `webflux_r2dbc_sample`: 2
2021-02-13 19:36:35.995  INFO 59550 --- [           main] o.f.core.internal.command.DbMigrate      : Schema `webflux_r2dbc_sample` is up to date. No migration necessary.
2021-02-13 19:36:36.312  INFO 59550 --- [           main] o.s.b.web.embedded.netty.NettyWebServer  : Netty started on port 8080
2021-02-13 19:36:36.327  INFO 59550 --- [           main] c.e.w.WebfluxR2dbcSampleApplicationKt    : Started WebfluxR2dbcSampleApplicationKt in 6.853 seconds (JVM running for 7.173)
```
8080番ポートで起動するようにしているので、ポートがin-useだと起動に失敗します。    
起動ポートは`application.yml`の`server.port`で変更可能です。
