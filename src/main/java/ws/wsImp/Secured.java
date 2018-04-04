package ws.wsImp;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
// need import by self, eclipse unable to auto detect these two packages
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;

import javax.ws.rs.NameBinding;

@NameBinding
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.METHOD })
public @interface Secured {}