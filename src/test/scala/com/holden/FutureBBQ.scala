import com.twitter.util.{Duration, ExecutorServiceFuturePool, Future, FuturePool, FutureTask, Promise}
import java.util.concurrent.{BlockingQueue, Callable, ExecutorService, Future => JFuture, LinkedBlockingQueue, ThreadFactory,
    ThreadPoolExecutor, TimeUnit, atomic}
import java.util.concurrent.{Executors, ExecutorService,TimeUnit}
import org.junit.Test
import org.junit._

import org.scalacheck._
import org.scalacheck.Gen._
import org.scalacheck.Arbitrary.arbitrary

import org.specs.SpecsMatchers
import org.specs.matcher.ScalaCheckMatchers


class FutureBBQTest extends SpecsMatchers with ScalaCheckMatchers {
  @Test
  def zeFutures {
    val future : Future[Int]= FutureNinja.esfp({
      println("bots")
      Thread.sleep(100)
      println("have feelings")
      1
    })
    Assert.assertEquals(1,future.get(Duration(1000,TimeUnit.SECONDS)))
  }
}
