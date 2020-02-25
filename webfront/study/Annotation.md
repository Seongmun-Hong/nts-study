@Retention(RetentionPolicy.RUNTIME) // 컴파일 이후에도 JVM에 의해서 참조가 가능합니다.
//@Retention(RetentionPolicy.CLASS) // 컴파일러가 클래스를 참조할 때까지 유효합니다.
//@Retention(RetentionPolicy.SOURCE) // 어노테이션 정보는 컴파일 이후 없어집니다.


SOURCE는 컴파일러에게서 버려진다. 즉 클래스에는 포함이 안된다이고,
Class는 default로서 Compiler에게 class file이 기록되지만 런타임시 가상머신에 의해 retain되지 않는다.
Runtime은Compiler에게 class file이 기록되고 At runtime에 VM에 의해 retain 된다고 나와있습니다.



SOURCE	소스상에서만 어노테이션 정보를 유지한다. 소스 코드를 분석할 때만 의미가 있으며 바이트 코드 파일에는 정보가 남지 않는다.
CLASS	바이트 코드 파일까지 어노테이션 정보를 유지한다. 하지만 리플렉션을 이용해서 어노테이션 정보를 얻을 수는 없다.
RUNTIME	바이트 코드 파일까지 어노테이션 정보를 유지하면서 리플렉션을 이용해서 런타임시에 어노테이션 정보를 얻을 수 있다.