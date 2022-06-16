package com.github.slugify;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Warmup(iterations = 5, time = 1)
@Measurement(iterations = 5, time = 1)
@Fork(1)
public class SlugifyBenchmark {
  @Param({"simple string",
      "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
      "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
      "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
      "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
      "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
      "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"})
  public String lengthVarySimpleString;

  @Param({"some \\u0105 letters ^ are % strange *",
      "\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105",
      "\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105",
      "\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105",
      "\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105",
      "\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105",
      "\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105\\u0105"})
  public String lengthVarySpecialString;

  @Benchmark
  public void stringLenghtPerformance() {
    Slugify.builder().build().slugify(lengthVarySimpleString);
  }

  @Benchmark
  public void specialStringLenghtPerformance() {
    Slugify.builder().build().slugify(lengthVarySpecialString);
  }

  public static void main(String[] args) throws RunnerException {
    Options opt = new OptionsBuilder().include(SlugifyBenchmark.class.getSimpleName()).build();
    new Runner(opt).run();
  }
}
