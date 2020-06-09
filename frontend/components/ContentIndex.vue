<template>
  <v-layout>
    <v-row>
      <v-col cols="12" md="12">
        <v-flex class="text-center">
          <p>{{ $t('about_me_context_text') }}</p>
        </v-flex>
      </v-col>
      <v-col cols="12" md="12">
        <v-divider></v-divider>
      </v-col>
      <v-col cols="12" md="12">
        <v-flex class="text-center">
          <h1 class="titles">{{ $t('skills_title_text') }}</h1>
        </v-flex>
      </v-col>
      <v-col cols="12" md="6">
        <client-only>
          <apexchart type="bar" height="350" :options="chartOptions" :series="series" />
        </client-only>
      </v-col>
      <v-col cols="12" md="6">
        <v-flex class="text-center">
          <h1 class="subtitles">{{ $t('languages_title_text') }}</h1>
          <div class="content-skills">{{ $t('languages_context_text') }}</div>
        </v-flex>
      </v-col>
      <v-col cols="12" md="12">
        <v-divider></v-divider>
      </v-col>
      <v-col cols="12" md="6">
        <v-flex class="text-center">
          <h1 class="subtitles">{{ $t('programming_languages_title_text') }}</h1>
          <div class="content-skills">{{ $t('programming_languages_context_text') }}</div>
        </v-flex>
      </v-col>
      <v-col cols="12" md="6">
        <client-only>
          <apexchart type="bar" height="350" :options="chartOptionsSkills" :series="seriesSkills" />
        </client-only>
      </v-col>
    </v-row>
  </v-layout>
</template>

<script>
export default {
  name: "Content",
  data() {
    return {
      series: [
        {
          name: this.$i18n.t("english_table_text"),
          data: [100, 95, 95]
        },
        {
          name: this.$i18n.t("spanish_table_text"),
          data: [100, 90, 95]
        }
      ],
      chartOptions: {
        chart: {
          height: 350,
          type: "bar",
          animations: {
            enabled: true,
            easing: "easeinout",
            speed: 800,
            animateGradually: {
              enabled: true,
              delay: 150
            },
            dynamicAnimation: {
              enabled: true,
              speed: 350
            }
          }
        },
        plotOptions: {
          bar: {
            horizontal: false,
            columnWidth: "60%",
            endingShape: "rounded"
          }
        },
        dataLabels: {
          enabled: false
        },
        legend: {
          show: true,
          markers: {
            fillColors: ["#96ceb4", "#ffeead"]
          }
        },
        stroke: {
          show: true,
          width: 2,
          colors: ["transparent"]
        },
        xaxis: {
          categories: [
            this.$i18n.t("speaking_table_text"),
            this.$i18n.t("writing_table_text"),
            this.$i18n.t("reading_table_text")
          ]
        },
        yaxis: {
          title: {
            text: "% (" + this.$i18n.t("percentage_table_text") + ")"
          }
        },
        fill: {
          opacity: 1,
          colors: ["#96ceb4", "#ffeead"]
        },
        tooltip: {
          y: {
            formatter: function(val) {
              return val + "%";
            }
          }
        }
      },
      seriesSkills: [
        {
          data: [80, 60, 50, 50, 45, 40, 20, 15, 10]
        }
      ],
      chartOptionsSkills: {
        chart: {
          type: "bar",
          height: 350,
          animations: {
            enabled: true,
            easing: "easeinout",
            speed: 800,
            animateGradually: {
              enabled: true,
              delay: 150
            },
            dynamicAnimation: {
              enabled: true,
              speed: 350
            }
          }
        },
        plotOptions: {
          bar: {
            barHeight: "100%",
            distributed: true,
            horizontal: true,
            dataLabels: {
              position: "bottom"
            }
          }
        },
        colors: [
          "#726a95",
          "#709fb0",
          "#a0c1b8",
          "#f4ebc1",
          "#efee9d",
          "#d1eaa3",
          "#dbc6eb",
          "#abc2e8",
          "#69d2e7"
        ],
        dataLabels: {
          enabled: true,
          textAnchor: "start",
          style: {
            colors: ["#fff"]
          },
          formatter: function(val, opt) {
            return val;
          },
          offsetX: 0,
          dropShadow: {
            enabled: true
          }
        },
        stroke: {
          width: 1,
          colors: ["#fff"]
        },
        xaxis: {
          categories: [
            "Java",
            "Groovy",
            "Python",
            "Shell scripting",
            "C",
            "Javascript",
            "SML",
            "Prolog",
            "Rust"
          ],
          labels: {
            show: false
          }
        },
        yaxis: {
          labels: {
            show: true
          }
        },
        // title: {
        //   text: "Custom DataLabels",
        //   align: "center",
        //   floating: true
        // },
        // subtitle: {
        //   text: "Category Names as DataLabels inside bars",
        //   align: "center"
        // },
        tooltip: {
          theme: "dark",
          x: {
            show: false
          },
          y: {
            title: {
              formatter: function() {
                return "";
              }
            }
          }
        }
      }
    };
  }
};
</script>

<style>
.titles {
  color: #7c795d;
  font-family: "Trocchi", serif;
  font-size: 45px;
  font-weight: normal;
  line-height: 48px;
  margin: 0;
  padding: 25px;
}
.subtitles {
  color: #7c795d;
  font-family: "Source Sans Pro", sans-serif;
  font-size: 30px;
  font-weight: 400;
  line-height: 32px;
}
.content-skills {
  display: table-cell;
  width: 100%;
  height: 300px;
  padding: 10px;
  /* border: 3px dashed #1c87c9; */
  vertical-align: middle;
}
</style>