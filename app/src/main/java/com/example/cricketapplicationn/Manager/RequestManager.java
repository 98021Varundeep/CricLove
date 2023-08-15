package com.example.cricketapplicationn.Manager;

import android.content.Context;
import android.os.health.HealthStats;
import android.text.style.AlignmentSpan;
import android.widget.Toast;

import com.example.cricketapplicationn.Model.FixtureResponse;
import com.example.cricketapplicationn.Model.GetPlayers;
import com.example.cricketapplicationn.Model.GetSquads;
import com.example.cricketapplicationn.Model.PlayerInfo;
import com.example.cricketapplicationn.Model.SereisMatches;
import com.example.cricketapplicationn.Model.getPlayerCareer;
import com.example.cricketapplicationn.Model.getPointTable;
import com.example.cricketapplicationn.Model.getVenues;
import com.example.cricketapplicationn.PlayerCareerListener;
import com.example.cricketapplicationn.PlayerInfoListener;
import com.example.cricketapplicationn.PlayerListener;
import com.example.cricketapplicationn.PointtableResposneLinstener;
import com.example.cricketapplicationn.ResponseListener;
import com.example.cricketapplicationn.SeriesResponseListener;
import com.example.cricketapplicationn.SquadResponseListener;
import com.example.cricketapplicationn.VenueResponseListener;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public class RequestManager {

    Context context;

    public RequestManager(Context context) {
        this.context = context;
    }

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://cricbuzz-cricket.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public void getPlayerCareer(PlayerCareerListener listener, int playerid) {
        CallFixtures fixtures = retrofit.create(CallFixtures.class);
        Call<getPlayerCareer> call = fixtures.getplayerCareer(playerid);
        call.enqueue(new Callback<getPlayerCareer>() {
            @Override
            public void onResponse(Call<getPlayerCareer> call, Response<getPlayerCareer> response) {
                if (!response.isSuccessful()) {
                    listener.didError(response.message());
                    return;
                }
                listener.didFetch(response.body().values, response.message());
            }

            @Override
            public void onFailure(Call<getPlayerCareer> call, Throwable t) {
                listener.didError(t.getMessage());
            }
        });
    }

    public void getPlayerInfo(PlayerInfoListener listener, int playerId) {
        CallFixtures fixtures = retrofit.create(CallFixtures.class);
        Call<PlayerInfo> call = fixtures.getPlayerInfo(playerId);
        call.enqueue(new Callback<PlayerInfo>() {
            @Override
            public void onResponse(Call<PlayerInfo> call, Response<PlayerInfo> response) {
                if (!response.isSuccessful()) {
//              Toast.makeText(context, "Can not Load data,Try Again", Toast.LENGTH_SHORT).show();
                    return;
                }
                listener.didFectch(response.body(), response.message());
            }


            @Override
            public void onFailure(Call<PlayerInfo> call, Throwable t) {
                listener.didError(t.getMessage());
            }
        });
    }

    public void getpllayers(PlayerListener listener, int seriesId, int squadId) {

        CallFixtures fixtures = retrofit.create(CallFixtures.class);
        Call<GetPlayers> call = fixtures.getplayers(seriesId, squadId);
        call.enqueue(new Callback<GetPlayers>() {
            @Override
            public void onResponse(Call<GetPlayers> call, Response<GetPlayers> response) {
                if (!response.isSuccessful()) {
                    listener.didError(response.message());
                    return;
                }
                listener.didFetch(response.body().player, response.message());
            }

            @Override
            public void onFailure(Call<GetPlayers> call, Throwable t) {
                listener.didError(t.getMessage());
            }
        });
    }

    public void getPointTable(PointtableResposneLinstener listener, int seriesId) {

        CallFixtures fixtures = retrofit.create(CallFixtures.class);
        Call<getPointTable> call = fixtures.getpointTable(seriesId);
        call.enqueue(new Callback<getPointTable>() {
            @Override
            public void onResponse(Call<getPointTable> call, Response<getPointTable> response) {
                if (!response.isSuccessful()) {
                    listener.didError(response.message());
                    return;

                }
                if (response.body() != null) {
                    listener.didFetch(response.body().pointsTable, response.message());
                } else {
                    listener.didError("Data not available ");
                    // Toast.makeText(, "", Toast.LENGTH_SHORT).show();
                }
            }
                @Override
                public void onFailure (Call < getPointTable > call, Throwable t){
                    listener.didError(t.getMessage());
                }
            });

        }
        public void getVenues (VenueResponseListener listener,int value){
            CallFixtures fixtures = retrofit.create(CallFixtures.class);
            Call<getVenues> call = fixtures.getVenue(value);
            call.enqueue(new Callback<getVenues>() {
                @Override
                public void onResponse(Call<getVenues> call, Response<getVenues> response) {
                    if (!response.isSuccessful()) {
                        listener.didError(response.message());
                        return;
                    }
                    listener.didFetch(response.body(), response.message());
                }

                @Override
                public void onFailure(Call<getVenues> call, Throwable t) {
                    listener.didError(t.getMessage());
                }
            });


        }
        public void getSeriesMatches (SeriesResponseListener listener,int seriesId){
            CallFixtures fixtures = retrofit.create(CallFixtures.class);
            Call<SereisMatches> call = fixtures.callSeries(seriesId);
            try {
                call.enqueue(new Callback<SereisMatches>() {
                    @Override

                    public void onResponse(Call<SereisMatches> call, Response<SereisMatches> response) {
                        if (!response.isSuccessful()) {
                            listener.didError(response.message());
                            return;
                        }
                        listener.didFetch(response.body().matchDetails, response.message());

                    }

                    @Override
                    public void onFailure(Call<SereisMatches> call, Throwable t) {
                        listener.didError(t.getMessage());
                    }
                });
            } catch (Exception e) {
                Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
            }

        }
        public void getFixture (ResponseListener listener, String type){
            CallFixtures fixtures = retrofit.create(CallFixtures.class);
            Call<FixtureResponse> call = fixtures.callFixtures(type);
            call.enqueue(new Callback<FixtureResponse>() {
                @Override
                public void onResponse(Call<FixtureResponse> call, Response<FixtureResponse> response) {
                    if (!response.isSuccessful()) {
                        listener.didError(response.message());
                        return;
                    }
                    listener.didFetch(response.body().typeMatches, response.message());
                }

                @Override
                public void onFailure(Call<FixtureResponse> call, Throwable t) {
                    listener.didError(t.getMessage());
                }
            });
        }
        public void getSquads (SquadResponseListener listener,int seriesId){
            CallFixtures fixtures = retrofit.create(CallFixtures.class);
            Call<GetSquads> call = fixtures.getSquad(seriesId);
            call.enqueue(new Callback<GetSquads>() {
                @Override
                public void onResponse(Call<GetSquads> call, Response<GetSquads> response) {
                    if (!response.isSuccessful()) {
                        listener.didError(response.message());
                        return;
                    }
                    listener.didFetch(response.body(), response.message());
                }

                @Override
                public void onFailure(Call<GetSquads> call, Throwable t) {
                    listener.didError(t.getMessage());
                }
            });
        }


        private interface CallFixtures {

            @GET("matches/v1/{type}")
            @Headers(
                    {"Accept:application/json",
                            "X-RapidAPI-Key:eef1b18323msh0412fe5c90d8fe7p1ccc2djsn42e3c4fcd02b",
                            "X-RapidAPI-Host: cricbuzz-cricket.p.rapidapi.com"

                    }
            )
            Call<FixtureResponse> callFixtures(
                    @Path("type") String type
            );

            @GET("series/v1/{seriesId}")
            @Headers(
                    {"Accept:application/json",
                            "X-RapidAPI-Key:eef1b18323msh0412fe5c90d8fe7p1ccc2djsn42e3c4fcd02b",
                            "X-RapidAPI-Host: cricbuzz-cricket.p.rapidapi.com"
                    }
            )
            Call<SereisMatches> callSeries(
                    @Path("seriesId") int seriesId
            );


            @GET("series/v1/{seriesId}/squads")
            @Headers(
                    {"Accept:application/json",
                            "X-RapidAPI-Key:eef1b18323msh0412fe5c90d8fe7p1ccc2djsn42e3c4fcd02b",
                            "X-RapidAPI-Host: cricbuzz-cricket.p.rapidapi.com"
                    }
            )
            Call<GetSquads> getSquad(
                    @Path("seriesId") int seriesId
            );


            @GET("series/v1/{seriesId}/venues")
            @Headers(
                    {"Accept:application/json",
                            "X-RapidAPI-Key: eef1b18323msh0412fe5c90d8fe7p1ccc2djsn42e3c4fcd02b",
                            "X-RapidAPI-Host: cricbuzz-cricket.p.rapidapi.com"
                    }
            )
            Call<getVenues> getVenue(
                    @Path("seriesId") int seriesId
            );


            @GET("stats/v1/series/{seriesId}/points-table")
            @Headers(
                    {"Accept:application/json",
                            "X-RapidAPI-Key:eef1b18323msh0412fe5c90d8fe7p1ccc2djsn42e3c4fcd02b",
                            "X-RapidAPI-Host: cricbuzz-cricket.p.rapidapi.com"
                    }
            )
            Call<getPointTable> getpointTable(
                    @Path("seriesId") int seriesId
            );


            @GET("series/v1/{seriesId}/squads/{squadId}")
            @Headers(
                    {"Accept:application/json",
                            "X-RapidAPI-Key:eef1b18323msh0412fe5c90d8fe7p1ccc2djsn42e3c4fcd02b",
                            "X-RapidAPI-Host: cricbuzz-cricket.p.rapidapi.com"
                    }
            )
            Call<GetPlayers> getplayers(
                    @Path("seriesId") int seriesId,
                    @Path("squadId") int squadId

            );

            @GET("stats/v1/player/{playerId}")
            @Headers(
                    {"Accept:application/json",
                            "X-RapidAPI-Key:eef1b18323msh0412fe5c90d8fe7p1ccc2djsn42e3c4fcd02b",
                            "X-RapidAPI-Host: cricbuzz-cricket.p.rapidapi.com"
                    }
            )
            Call<PlayerInfo> getPlayerInfo(
                    @Path("playerId") int playerId
            );

            @GET("stats/v1/player/{playerId}/career")
            @Headers(
                    {"Accept:application/json",
                            "X-RapidAPI-Key:eef1b18323msh0412fe5c90d8fe7p1ccc2djsn42e3c4fcd02b",
                            "X-RapidAPI-Host: cricbuzz-cricket.p.rapidapi.com"
                    }
            )
            Call<getPlayerCareer> getplayerCareer(
                    @Path("playerId") int playerId

            );
        }
    }