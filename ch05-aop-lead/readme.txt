动态代理:可以在程序执行的过程中,创建代理对象
通过代理对象的方式,给目标类增加额外的功能(功能增强)

实现步骤:
1.创建目标类,SomeService 目标类,给它的doSome() ,doOther()增加 时间,事务功能.
2.创建InvocationHandler 接口的实现类,在这个类实现给目标代码增加功．
３.使用jdk 的类Proxy ,创建代理对象,实现创建对象的能力.